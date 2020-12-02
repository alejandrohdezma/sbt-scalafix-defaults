ThisBuild / scalaVersion                  := "2.12.12"
ThisBuild / organization                  := "com.alejandrohdezma"
ThisBuild / scalafixDependencies         ++= scalafixDefaultDependencies
ThisBuild / pluginCrossBuild / sbtVersion := "1.3.0"

addCommandAlias("ci-test", "scalafixEnable; fix --check; mdoc; test; scripted")
addCommandAlias("ci-docs", "github; mdoc; headerCreateAll")
addCommandAlias("ci-publish", "github; ci-release")

lazy val scalafix = "ch.epfl.scala" % "sbt-scalafix" % "[0.9.0,)" % Provided // scala-steward:off

lazy val documentation = project
  .enablePlugins(MdocPlugin)
  .settings(mdocOut := file("."))

lazy val `sbt-scalafix-defaults` = module
  .enablePlugins(TestsPlugin)
  .enablePlugins(SbtPlugin)
  .settings(addSbtPlugin(scalafix))
  .settings(scalacOptions.in(Test) --= scalacOptionsFor(scalaVersion.value))
  .settings(scriptedLaunchOpts += s"-Dplugin.version=${version.value}")
  .settings(Compile / unmanagedResources += baseDirectory.in(LocalRootProject).value / ".scalafix.conf")
  .settings(libraryDependencies += "org.typelevel" %% "cats-core" % "2.3.0" % Test)
