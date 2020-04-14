// So `scala-steward` can auto-update scalafix dependencies
unmanagedSources in Compile += {
  baseDirectory
    .in(LocalRootProject)
    .value
    .getParentFile / "sbt-scalafix-defaults" / "src" / "main" / "scala" / "com" / "alejandrohdezma" / "sbt" / "scalafix" / "defaults" / "ScalafixDependenciesPlugin.scala"
}
