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
      "com.github.vovapolu" %% "scaluzzi"         % "0.1.5",
      "com.nequissimus"     %% "sort-imports"     % "0.3.2",
      "com.eed3si9n.fix"    %% "scalafix-noinfer" % "0.1.0-M1"
    )

  }

}
