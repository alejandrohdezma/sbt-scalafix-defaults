ThisBuild / scalaVersion          := "2.12.12"
ThisBuild / organization          := "com.alejandrohdezma"
ThisBuild / scalafixDependencies ++= scalafixDefaultDependencies

Global / onChangedBuildSource := ReloadOnSourceChanges

addCommandAlias("ci-test", "fix --check; mdoc; test; scripted")
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
  .settings(libraryDependencies += "org.typelevel" %% "cats-core" % "2.1.1" % Test)
