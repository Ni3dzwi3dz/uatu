package pl.idzieniedzwiedz.uatu.repository

import pl.idzieniedzwiedz.uatu.models.ToDo
import io.getquill.*
import zio.*
import java.sql.SQLException

class ToDoRepository:
    private inline def queryToDo = quote {querySchema[ToDo]("todos")}

    def getAllTodos: IO[SQLException, List[ToDo]] = 


