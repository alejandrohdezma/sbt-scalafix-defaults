// So `scala-steward` can auto-update scalafix dependencies
unmanagedSources in Compile += {
  baseDirectory
    .in(LocalRootProject)
    .value
    .getParentFile / "modules" / "sbt-scalafix-defaults" / "src" / "main" / "scala" / "com" / "alejandrohdezma" / "sbt" / "scalafix" / "defaults" / "ScalafixDependenciesPlugin.scala"
}
