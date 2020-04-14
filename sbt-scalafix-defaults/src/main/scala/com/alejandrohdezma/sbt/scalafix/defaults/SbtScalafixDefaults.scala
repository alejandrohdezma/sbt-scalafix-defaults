package com.alejandrohdezma.sbt.scalafix.defaults

import com.alejandrohdezma.sbt.scalafix.defaults.ScalafixDependenciesPlugin.autoImport.scalafixDefaultDependencies
import sbt.Keys.onLoad
import sbt._
import scalafix.sbt.ScalafixPlugin
import scalafix.sbt.ScalafixPlugin.autoImport._

import scala.io.Source

object SbtScalafixDefaults extends AutoPlugin {

  override def requires: Plugins = ScalafixPlugin

  override def trigger = allRequirements

  override def globalSettings: Seq[Def.Setting[_]] = Seq(
    scalafixDependencies ++= scalafixDefaultDependencies,
    onLoad := onLoad.value andThen { state =>
      val configurations = Source.fromResource(".scalafix.conf", getClass.getClassLoader).mkString
      IO.write(file(".scalafix.conf"), noEditWarning)
      IO.append(file(".scalafix.conf"), configurations)
      state
    }
  )

  private val noEditWarning =
    """# This file has been automatically generated and should
      |# not be edited nor added to source control systems.
      |
      |# To edit the original configurations go to
      |# https://github.com/alejandrohdezma/sbt-scalafix-defaults/edit/master/.scalafix.conf
      |
      |""".stripMargin

}
