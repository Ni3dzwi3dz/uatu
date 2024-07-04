import Dependencies._

ThisBuild / organization := "pl.idzieniedzwiedz"
ThisBuild / version := "0.0.1"
ThisBuild / scalaVersion      := "3.4.1"
ThisBuild / fork              := true
ThisBuild / semanticdbEnabled := true
ThisBuild / semanticdbVersion := scalafixSemanticdb.revision
ThisBuild / scalafixDependencies ++= List("com.github.liancheng" %% "organize-imports" % "0.6.0")

lazy val postgresVer  = "42.7.3"
lazy val zioConfigVer = "4.0.2"
lazy val zioJDBCVer   = "0.1.2"

def settingsApp = Seq(
  name := "uatu",
  Compile / run / mainClass := Option("pl.idzieniedzwiedz.uatu.MainApp"),
  testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework"),
  libraryDependencies ++= zioDeps ++ dbDeps ++ tapirDeps ++ testDeps,
)

def settingsDocker = Seq(
  Docker / version          := version.value,
  dockerBaseImage := "eclipse-temurin:20.0.1_9-jre",
)


lazy val root = (project in file("."))
  .enablePlugins(JavaAppPackaging)
  .settings(settingsApp)
  .settings(settingsDocker)
  .settings(libraryDependencies ++= zioDeps ++ dbDeps ++ tapirDeps)

addCommandAlias("fmt", "scalafmt; Test / scalafmt; sFix;")
addCommandAlias("fmtCheck", "scalafmtCheck; Test / scalafmtCheck; sFixCheck")
addCommandAlias("sFix", "scalafix OrganizeImports; Test / scalafix OrganizeImports")
addCommandAlias("sFixCheck", "scalafix --check OrganizeImports; Test / scalafix --check OrganizeImports")
