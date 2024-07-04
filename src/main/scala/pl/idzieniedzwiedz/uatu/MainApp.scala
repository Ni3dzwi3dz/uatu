package pl.idzieniedzwiedz.uatu

import zio._
import zio.http._
import zio.http.endpoint._
import zio.config.typesafe.TypesafeConfigProvider

import pl.idzieniedzwiedz.uatu.config.UatuConfig

object MainApp extends ZIOAppDefault:

  override val bootstrap: ZLayer[ZIOAppArgs, Any, Any] = Runtime.setConfigProvider(
    TypesafeConfigProvider.fromResourcePath()
  )
  override val run = {
    // Console.printLine("please visit http://localhost:8080") *> 
    // Server.serve(routes).provide(Server.default)
    for {
      config <-ZIO.config(UatuConfig.config)
      _ <- Console.print(config.database)
    } yield ()
  }