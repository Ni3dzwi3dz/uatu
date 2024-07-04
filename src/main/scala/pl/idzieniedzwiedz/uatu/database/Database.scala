package pl.idzieniedzwiedz.uatu.database

import pl.idzieniedzwiedz.uatu.config.DatabaseConfig

import com.zaxxer.hikari.*
import javax.sql.DataSource
import zio.*


object Database:
    private def create(config: DatabaseConfig): HikariDataSource = 
      val hikariConfig = new HikariConfig()
      hikariConfig.setJdbcUrl(config.url)
      hikariConfig.setUsername(config.username)
      hikariConfig.setPassword(config.password)
      hikariConfig.setDriverClassName(config.driver)
      new HikariDataSource(hikariConfig)

    val live: ZLayer[DatabaseConfig, Nothing, DataSource] =
    ZLayer.scoped {
      ZIO.fromAutoCloseable {
        for
          config     <- ZIO.service[DatabaseConfig]
          dataSource <- ZIO.succeed(create(config))
        yield dataSource
      }
    }

