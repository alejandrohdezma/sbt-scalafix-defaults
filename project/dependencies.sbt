// So `scala-steward` can auto-update scalafix dependencies
Compile / unmanagedSources += {
  (LocalRootProject / baseDirectory).value.getParentFile / "modules" / "sbt-scalafix-defaults" / "src" / "main" /
    "scala" / "com" / "alejandrohdezma" / "sbt" / "scalafix" / "defaults" / "ScalafixDependenciesPlugin.scala"
}
