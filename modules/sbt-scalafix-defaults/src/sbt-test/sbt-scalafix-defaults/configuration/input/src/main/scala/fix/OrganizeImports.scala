/*
rules = [
  DisableSyntax
  LeakingImplicitClassVal
  NoValInForComprehension
  OrganizeImports
  ProcedureSyntax
  RedundantSyntax
  RemoveUnused
]

OrganizeImports {
  expandRelative = true
  removeUnused = true
  groups = [
    "re:java?\\.",
    "scala.",
    "cats.",
    "sbt.",
    "*",
    "com.sun."
  ]
}

RemoveUnused.imports = false

DisableSyntax {
  noAsInstanceOf = false
  noContravariantTypes = false
  noCovariantTypes = false
  noDefaultArgs = false
  noFinalVal = true
  noFinalize = true
  noImplicitConversion = true
  noImplicitObject = true
  noIsInstanceOf = false
  noNulls = true
  noReturns = true
  noSemicolons = true
  noTabs = true
  noThrows = true
  noUniversalEquality = true
  noValInAbstract = true
  noValPatterns = true
  noVars = true
  noWhileLoops = true
  noXml = true
}
 */

import cats.kernel.Eq
import cats.kernel.Hash
import cats.Show
import cats.implicits._
import scala.math.abs
import scala.math.acos
import com.sun.crypto.provider.RSACipher
import scala.concurrent.duration._
import java.util.UUID
import java.util.ArrayList

object OrganizeImports {

  val eqString   = implicitly[Eq[String]]

  val hashString = implicitly[Hash[String]]

  val showString = implicitly[Show[String]]

  val oneMinute  = 1.minute

  val randomUUID = UUID.randomUUID()

  val myList     = new ArrayList[String]()

}
