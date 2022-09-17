ThisBuild / scalaVersion                  := "2.12.17"
ThisBuild / organization                  := "com.alejandrohdezma"
ThisBuild / scalafixDependencies         ++= scalafixDefaultDependencies
ThisBuild / pluginCrossBuild / sbtVersion := "1.3.0"
ThisBuild / semanticdbEnabled             := true
ThisBuild / semanticdbVersion             := scalafixSemanticdb.revision

addCommandAlias("ci-test", "fix --check; mdoc; scripted")
addCommandAlias("ci-docs", "github; mdoc; headerCreateAll")
addCommandAlias("ci-publish", "github; ci-release")

lazy val scalafix = "ch.epfl.scala" % "sbt-scalafix" % "[0.9.0,)" % Provided // scala-steward:off

lazy val documentation = project
  .enablePlugins(MdocPlugin)
  .settings(mdocOut := file("."))

lazy val `sbt-scalafix-defaults` = module
  .enablePlugins(SbtPlugin)
  .settings(addSbtPlugin(scalafix))
  .settings(scriptedLaunchOpts += s"-Dplugin.version=${version.value}")
  .settings(Compile / unmanagedResources += (LocalRootProject / baseDirectory).value / ".scalafix.conf")
  .settings(Compile / unmanagedResources += (LocalRootProject / baseDirectory).value / ".scalafix-3.conf")
