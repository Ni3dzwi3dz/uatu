package pl.idzieniedzwiedz.uatu.repository

import java.sql.SQLException

import io.getquill.*
import io.getquill.jdbczio.*
import pl.idzieniedzwiedz.uatu.models.*
import zio.*

class TaskRepository(quill: Quill.Postgres[SnakeCase]):
  import quill.*

  inline private def queryToDo = quote(querySchema[TaskRow](entity = "tasks"))

  def getAllTodos: IO[SQLException, List[TaskRow]] = run(queryToDo).map(_.toList)

  def getTodoById(id: Int): IO[SQLException, Option[TaskRow]] =
    run(queryToDo.filter(_.id == lift(id))).map(_.headOption)

  def insertTodo(task: SimpleTask) = run(
    queryToDo
      .insert(
        _.name        -> lift(task.name),
        _.description -> lift(task.description),
        _.dueDate     -> lift(task.dueDate),
      )
      .returning(_.id),
  )
  // TODO: Add updateTodo  and deleteTodo method
