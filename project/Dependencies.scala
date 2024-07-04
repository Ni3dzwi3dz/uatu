import sbt._

object Dependencies {


  val zioVersion          = "2.0.13"
  val zioHttpVersion      = "3.0.0-RC8"
  val zioConfigVersion    = "4.0.2"

  val tapirVersion = "1.10.10"

  val quillVersion        = "4.7.3"
  val postgresVersion     = "42.7.3"
  val hikariVersion       = "5.0.0"

  val zioDeps = Seq(
  "dev.zio"     %% "zio-http"            % zioHttpVersion,
  "dev.zio"     %% "zio-config"          % zioConfigVersion,
  "dev.zio"     %% "zio-config-magnolia" % zioConfigVersion,
  "dev.zio"     %% "zio-config-typesafe" % zioConfigVersion,
  "dev.zio"     %% "zio-config-refined"  % zioConfigVersion,
  )

  val tapirDeps = Seq(
  "com.softwaremill.sttp.tapir" %% "tapir-zio-http-server" % tapirVersion,
  "com.softwaremill.sttp.tapir" %% "tapir-json-zio" % tapirVersion,
  "com.softwaremill.sttp.tapir" %% "tapir-swagger-ui-bundle" % tapirVersion
)

  val dbDeps = Seq(
  "io.getquill"   %% "quill-jdbc-zio" % quillVersion,
  "org.postgresql" % "postgresql" % postgresVersion,
  "com.zaxxer" % "HikariCP" % hikariVersion,
  )


  val testDeps = Seq(
  "dev.zio"     %% "zio-test"     % zioVersion % Test,
  "dev.zio"     %% "zio-test-sbt" % zioVersion % Test,
  "dev.zio"     %% "zio-test-magnolia" % zioVersion % Test  
  )
}
