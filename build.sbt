ThisBuild / scalaVersion         := "2.12.11"
ThisBuild / organization         := "com.alejandrohdezma"
ThisBuild / scalafixDependencies ++= scalafixDefaultDependencies

Global / onChangedBuildSource := ReloadOnSourceChanges

addCommandAlias("ci-test", "scalafmtCheckAll; scalafmtSbtCheck; mdoc; scripted")
addCommandAlias("ci-docs", "mdoc; headerCreateAll")

skip in publish := true

lazy val scalafix = "ch.epfl.scala" % "sbt-scalafix" % "[0.9.0,)" % Provided // scala-steward:off

lazy val docs = project
  .in(file("sbt-scalafix-defaults-docs"))
  .enablePlugins(MdocPlugin)
  .settings(skip in publish := true)
  .settings(mdocOut := file("."))

lazy val `sbt-scalafix-defaults` = project
  .enablePlugins(SbtPlugin)
  .settings(addSbtPlugin(scalafix))
  .settings(scriptedLaunchOpts += s"-Dplugin.version=${version.value}")
  .settings(Compile / unmanagedResources += baseDirectory.value.getParentFile / ".scalafix.conf")
