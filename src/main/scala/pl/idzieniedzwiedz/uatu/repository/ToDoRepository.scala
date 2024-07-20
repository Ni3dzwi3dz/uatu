package pl.idzieniedzwiedz.uatu.repository

import java.sql.SQLException

import io.getquill.*
import io.getquill.jdbczio.*
import pl.idzieniedzwiedz.uatu.models.*
import zio.*
import scala.tools.nsc.doc.html.HtmlTags.U

class ToDoRepository(quill: Quill.Postgres[SnakeCase]):
  import quill.*

  inline private def queryToDo = quote(querySchema[ToDoRow](entity = "todos"))

  def getAllTodos: IO[SQLException, List[ToDoRow]] = run(queryToDo).map(_.toList)

  def getTodoById(id: Int): IO[SQLException, Option[ToDoRow]] =
    run(queryToDo.filter(_.id == lift(id))).map(_.headOption)

  def insertTodo(todo_id: Int, todo_type: String) = run(
    queryToDo
      .insert(_.todo_id -> lift(todo_id), _.todo_type -> lift(todo_type))
      .returning(_.id),
  )

  def updateTodo(updateData: UpdateToDo): IO[SQLException, Long] = run(
    queryToDo
      .dynamic
      .filter(_.id == lift(updateData.id))
      .update(
        setOpt(_.todo_id, updateData.todo_id),
        setOpt(_.todo_type, updateData.todo_type)
      )
    )

  def deleteTodoById(id: Int): IO[SQLException, Long] = run(
    queryToDo.filter(_.id == lift(id)).delete)

  object ToDoRepository:
    val live: ZLayer[Quill.Postgres[SnakeCase], Nothing, ToDoRepository] =
      ZLayer.fromFunction(new ToDoRepository(_))
