ThisBuild / scalaVersion                  := _root_.scalafix.sbt.BuildInfo.scala212
ThisBuild / crossScalaVersions            := Seq(scalaVersion.value, "3.8.4")
ThisBuild / organization                  := "com.alejandrohdezma"
ThisBuild / pluginCrossBuild / sbtVersion := scalaVersion.value.on(2)("1.12.14").getOrElse("2.0.0")
ThisBuild / semanticdbEnabled             := true
ThisBuild / semanticdbVersion             := scalafixSemanticdb.revision
ThisBuild / versionPolicyIntention        := Compatibility.BinaryAndSourceCompatible

addCommandAlias("ci-test", "fix --check; +versionPolicyCheck; mdoc; +publishLocal; +scripted")
addCommandAlias("ci-docs", "github; mdoc; headerCreateAll")
addCommandAlias("ci-publish", "versionCheck; github; ci-release")

lazy val scalafix = "ch.epfl.scala" % "sbt-scalafix" % "[0.12.0,)" % Provided // scala-steward:off

lazy val documentation = project
  .enablePlugins(MdocPlugin)

lazy val `sbt-scalafix-defaults` = module
  .enablePlugins(SbtPlugin)
  .settings(addSbtPlugin(scalafix))
  .settings(scriptedLaunchOpts += s"-Dplugin.version=${version.value}")
  .settings(Compile / unmanagedResources += (LocalRootProject / baseDirectory).value / ".scalafix.conf")
