// For using the plugin in its own build
unmanagedSourceDirectories in Compile +=
  baseDirectory.in(ThisBuild).value.getParentFile / "modules" / "sbt-scalafix-defaults" / "src" / "main" / "scala"
unmanagedResources in Compile +=
  baseDirectory.in(ThisBuild).value.getParentFile / ".scalafix.conf"
