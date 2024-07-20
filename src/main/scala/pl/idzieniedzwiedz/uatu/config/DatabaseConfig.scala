package pl.idzieniedzwiedz.uatu.config

import zio.*

final case class DatabaseConfig(
    host: String,
    port: Int,
    username: String,
    password: String,
    database: String,
  ):
  val url    = s"jdbc:postgresql://$host:$port/$database"
  val driver = "org.postgresql.Driver"
object DatabaseConfig:
  val live: ZLayer[UatuConfig, Nothing, DatabaseConfig] = ZLayer.fromZIO {
    ZIO.service[UatuConfig].map(_.database)
  }
