# @DESCRIPTION@

[![][github-action-badge]][github-action] [![][maven-badge]][maven] [![][steward-badge]][steward]

## Installation

Add the following line to your `plugins.sbt` file:

```sbt
addSbtPlugin("com.alejandrohdezma" % "sbt-scalafix-defaults" % "@VERSION@")
```

> You'll also need to provide the [`sbt-scalafix` plugin](https://github.com/scalacenter/sbt-scalafix).

## Usage

The included plugin activates automatically. It will add some default dependencies to `scalafixDependencies`, enable `scalafixOnCompile`(except when running on CI) & semanticdb by default and create a `.scalafix.conf` in your project's root folder with [this content](https://github.com/alejandrohdezma/sbt-scalafix-defaults/blob/master/.scalafix.conf).

> You can add the `.scalafix.conf` file to the repository's `.gitignore`, since it's going to be automatically re-created on every build.

### Extra configurations

Extra configurations can be added to a file named `.scalafix-extra.conf` at the root of your repository. The content of this file will be automatically appended to the auto-generated `.scalafix.conf`.

[github-action]: https://github.com/alejandrohdezma/sbt-scalafix-defaults/actions
[github-action-badge]: https://img.shields.io/endpoint.svg?url=https%3A%2F%2Factions-badge.atrox.dev%2Falejandrohdezma%2Fsbt-scalafix-defaults%2Fbadge%3Fref%3Dmaster&style=flat
[maven]: https://search.maven.org/search?q=g:%20com.alejandrohdezma%20AND%20a:sbt-scalafix-defaults
[maven-badge]: https://maven-badges.herokuapp.com/maven-central/com.alejandrohdezma/sbt-scalafix-defaults/badge.svg?kill_cache=1
[steward]: https://scala-steward.org
[steward-badge]: https://img.shields.io/badge/Scala_Steward-helping-brightgreen.svg?style=flat&logo=data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA4AAAAQCAMAAAARSr4IAAAAVFBMVEUAAACHjojlOy5NWlrKzcYRKjGFjIbp293YycuLa3pYY2LSqql4f3pCUFTgSjNodYRmcXUsPD/NTTbjRS+2jomhgnzNc223cGvZS0HaSD0XLjbaSjElhIr+AAAAAXRSTlMAQObYZgAAAHlJREFUCNdNyosOwyAIhWHAQS1Vt7a77/3fcxxdmv0xwmckutAR1nkm4ggbyEcg/wWmlGLDAA3oL50xi6fk5ffZ3E2E3QfZDCcCN2YtbEWZt+Drc6u6rlqv7Uk0LdKqqr5rk2UCRXOk0vmQKGfc94nOJyQjouF9H/wCc9gECEYfONoAAAAASUVORK5CYII=
