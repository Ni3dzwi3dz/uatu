package pl.idzieniedzwiedz.uatu.config

import zio.config.*
import zio.config.derivation.discriminator
import zio.config.magnolia.deriveConfig
import zio.config.typesafe.*
import zio.{Config, ZIO, ZLayer}

final case class UatuConfig(
    database: DatabaseConfig,
  )

object UatuConfig:
  val config: Config[UatuConfig] = deriveConfig[UatuConfig]

  lazy val live: ZLayer[Any, Config.Error, UatuConfig] =
    ZLayer.fromZIO {
      ZIO.config[UatuConfig](UatuConfig.config).map { c =>
        UatuConfig(
          database = c.database,
        )
      }
    }
