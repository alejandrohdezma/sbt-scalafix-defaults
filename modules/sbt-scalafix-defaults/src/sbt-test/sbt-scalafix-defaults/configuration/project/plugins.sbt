resolvers                         += Resolver.sonatypeRepo("releases")
addSbtPlugin("ch.epfl.scala"       % "sbt-scalafix"          % "0.9.30")
addSbtPlugin("com.eed3si9n"        % "sbt-projectmatrix"     % "0.8.0")
addSbtPlugin("com.alejandrohdezma" % "sbt-scalafix-defaults" % sys.props("plugin.version"))
