val scala3Version = "3.3.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "Scala 3 graphql",
    version := "0.1.0",
    scalaVersion := scala3Version,
    libraryDependencies ++= Seq(
      "com.github.ghostdogpr" %% "caliban" % "2.5.1",
      "org.scalameta" %% "munit" % "0.7.29" % Test,
      "dev.zio" %% "zio" % "2.1-RC1",
    )
  )
