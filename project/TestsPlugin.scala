import sbt.Keys._
import sbt._
import sbt.plugins._

import scalafix.sbt.BuildInfo.scalafixVersion
import scalafix.sbt.ScalafixPlugin.autoImport.scalafixDependencies
import scalafix.sbt.ScalafixTestkitPlugin.autoImport._
import scalafix.sbt.ScalafixTestkitPlugin

/**
 * Enable testing of a `.scalafix.conf` file using `ScalafixTestkitPlugin`.
 *
 * It enables adding input/output tests inside `test/resources/input` and `test/resources/output`
 * as expected by `ScalafixTestkitPlugin`.
 */
object TestsPlugin extends AutoPlugin {

  override def requires: Plugins = JvmPlugin

  override def projectSettings: Seq[Def.Setting[_]] =
    Seq(
      libraryDependencies                    += testkit % Test cross CrossVersion.full,
      libraryDependencies                   ++= scalafixDependencies.value.map(_ % Test),
      Test / sourceGenerators                += generateTests.taskValue,
      Test / sourceGenerators                += generateInput.taskValue,
      scalafixTestkitOutputSourceDirectories := Seq((Test / resourceDirectory).value / "output"),
      scalafixTestkitInputSourceDirectories  := Seq((Test / sourceManaged).value / "input"),
      scalafixTestkitInputClasspath          := (ThisProject / Compile / fullClasspath).value
    ) ++ ScalafixTestkitPlugin.projectSettings

  val testkit = "ch.epfl.scala" % "scalafix-testkit" % scalafixVersion

  private val generateInput = Def.task {
    val inputDirectory = (Test / resourceDirectory).value / "input"

    val scalafixConf = IO.read((LocalRootProject / baseDirectory).value / ".scalafix.conf")

    inputDirectory.listFiles.toSeq.map { file =>
      val newFile = (Test / sourceManaged).value / "input" / file.getName

      val content = s"/*\n$scalafixConf\n*/\n\n" + IO.read(file)

      IO.write(newFile, content)

      newFile
    }
  }

  private val generateTests = Def.task {
    val file = (Test / sourceManaged).value / "RuleSuite.scala"

    val suite =
      """class RuleSuite extends scalafix.testkit.AbstractSemanticRuleSuite with org.scalatest.FunSpecLike {
        |   runAllTests()
        |}""".stripMargin

    IO.write(file, suite)

    Seq(file)
  }

}
