/*
 * Copyright 2020-2026 Alejandro Hernández <https://github.com/alejandrohdezma>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alejandrohdezma.sbt.scalafix.defaults

import scala.io.Source

import sbt.Def
import sbt.Keys._
import sbt._

import scalafix.sbt.ScalafixPlugin
import scalafix.sbt.ScalafixPlugin.autoImport._

object SbtScalafixDefaults extends AutoPlugin {

  override def requires: Plugins = ScalafixPlugin

  override def trigger = allRequirements

  override def buildSettings: Seq[Def.Setting[_]] = Seq(
    semanticdbEnabled := true,
    semanticdbVersion := scalafixSemanticdb.revision
  )

  override def projectSettings: Seq[Def.Setting[_]] = Seq(
    scalafixConfig := {
      val defaults = Source.fromResource(".scalafix.conf", getClass.getClassLoader).mkString

      IO.write(file(".scalafix.conf"), defaults)

      val extra = file(".scalafix-extra.conf")

      if (extra.exists())
        IO.append(file(".scalafix.conf"), "\n" + IO.read(extra))

      Some(file(".scalafix.conf"))
    },
    scalacOptions ++= on { case (2, _) => Seq("-Yrangepos") }.value,
    scalacOptions ++= on { case (2, _) => Seq("-Xplugin-require:semanticdb") }.value,
    scalacOptions ++= on {
      case (2, 13) => Seq("-Wunused", "-Wconf:cat=unused:info")
      case (2, 12) => Seq("-Ywarn-unused")
      case (3, _)  => Seq("-Wconf:id=E198:info", "-Wunused:all")
    }.value
  )

  private def on[A](pf: PartialFunction[(Long, Long), Seq[A]]): Def.Initialize[Seq[A]] = Def.setting {
    CrossVersion.partialVersion(scalaVersion.value) match {
      case Some(v) => pf.lift(v).getOrElse(Nil)
      case _       => Nil
    }
  }

}
