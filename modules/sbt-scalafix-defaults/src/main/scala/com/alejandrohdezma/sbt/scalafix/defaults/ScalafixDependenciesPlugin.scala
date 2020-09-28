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

import sbt._

/**
 * This plugin just exposes the default Scalafix dependencies to they can be
 * automatically updated by `scala-steward`.
 */
object ScalafixDependenciesPlugin extends AutoPlugin {

  object autoImport {

    /** Scalafix dependencies added by this plugin */
    lazy val scalafixDefaultDependencies: Seq[ModuleID] = Seq(
      "com.github.liancheng" %% "organize-imports" % "0.4.2",
      "com.github.vovapolu"  %% "scaluzzi"         % "0.1.14"
    )

  }

}
