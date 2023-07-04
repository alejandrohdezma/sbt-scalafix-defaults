# @DESCRIPTION@

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
