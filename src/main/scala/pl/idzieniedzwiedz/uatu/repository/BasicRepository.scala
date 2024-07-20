package pl.idzieniedzwiedz.uatu.repository

import java.sql.SQLException
import io.getquill.*
import io.getquill.jdbczio.*
import zio.*

import pl.idzieniedzwiedz.uatu.models.*


// class BasicRepository[R <: Row](quill: Quill.Postgres[SnakeCase], entity: String):
//   import quill.*



//   inline private def query = quote(querySchema[R](entity = entity))

//   def getAll: IO[SQLException, List[R]] = run(query).map(_.toList)

//   def getById(id: Int): IO[SQLException, Option[R]] =
//     run(query.filter(_.id == lift(id))).map(_.headOption)

//   def insert(value: R): IO[SQLException, Int] = run(
//     query
//       .insertValue(value)
//       .returning(_.id),
//   )
