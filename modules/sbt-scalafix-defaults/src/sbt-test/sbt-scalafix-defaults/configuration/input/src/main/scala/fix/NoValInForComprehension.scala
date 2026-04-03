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

object NoValInForComprehension {

  for {
    n      <- List(1, 2, 3)
    val inc = n + 1
  } yield inc

}
