import Dependencies._

lazy val zioVersion = "1.0.0-RC11-1"

lazy val `zio-streams-example` = (project in file("."))
  .settings(
    inThisBuild(Seq(
      scalaVersion := "2.13.0",
      version := "0.1.0-SNAPSHOT",
      organization := "io.github.DmytroOrlov"
    )),
    addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.10.3"),
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio" % zioVersion,
      "dev.zio" %% "zio-streams" % zioVersion,
      "dev.zio" %% "zio-interop-cats" % "2.0.0.0-RC2",
      "org.typelevel" %% "cats-core" % "2.0.0-RC2",
      scalaTest % Test,
      scalaCheck % Test
    )
  )
