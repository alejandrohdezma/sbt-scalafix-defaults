/*
 * Copyright 2020 Alejandro Hernández <https://github.com/alejandrohdezma>
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

import sbt.Keys.onLoad
import sbt._

import com.alejandrohdezma.sbt.scalafix.defaults.ScalafixDependenciesPlugin.autoImport.scalafixDefaultDependencies
import scalafix.sbt.ScalafixPlugin
import scalafix.sbt.ScalafixPlugin.autoImport._

object SbtScalafixDefaults extends AutoPlugin {

  override def requires: Plugins = ScalafixPlugin

  override def trigger = allRequirements

  @SuppressWarnings(Array("scalafix:Disable.blocking.io"))
  override def globalSettings: Seq[Def.Setting[_]] =
    Seq(
      scalafixDependencies ++= scalafixDefaultDependencies,
      onLoad := onLoad.value andThen { state =>
        val defaults = Source.fromResource(".scalafix.conf", getClass.getClassLoader).mkString
        IO.write(file(".scalafix.conf"), defaults)

        val extra = file(".scalafix-extra.conf")

        if (extra.exists())
          IO.append(file(".scalafix.conf"), "\n" + IO.read(extra))

        state
      }
    )

}
