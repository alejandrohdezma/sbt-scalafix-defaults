sys.props.get("plugin.version") match {
  case Some(x) => addSbtPlugin("com.alejandrohdezma" % "sbt-scalafix-defaults" % x)
  case _       => sys.error("https://www.scala-sbt.org/1.x/docs/Testing-sbt-plugins.html")
}
addSbtPlugin("ch.epfl.scala" % "sbt-scalafix" % "0.9.24")
