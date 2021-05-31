/*
rules = [
  Disable
  DisableSyntax
  LeakingImplicitClassVal
  MissingFinal
  NoValInForComprehension
  OrganizeImports
  ProcedureSyntax
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

Disable.symbols = [
  {
    regex = {
      includes = [
        "^\\Qscala/util/Either.RightProjection#get().\\E$",
        "^\\Qscala/util/Either.LeftProjection#get().\\E$"
      ]
    }
    id = "Either.get"
    message = """
      Do not use Either.get(). It can throw an exception in case of wrong side.
      To disable this error you can use:
        - @SuppressWarnings(Array("scalafix:Disable.Either.get"))
        - // scalafix:ok Disable.Either.get
    """
  }
  {
    regex = {
      includes = [
        "^\\Qscala/Option#get().\\E$",
        "^\\Qscala/Some#get().\\E$",
        "^\\Qscala/None.get().\\E$"
      ]
    }
    id = "Option.get"
    message = """
      Do not use Option.get(). It can throw an exception in case of None.
      To disable this error you can use:
        - @SuppressWarnings(Array("scalafix:Disable.Option.get"))
        - // scalafix:ok Disable.Option.get
    """
  }
  {
    regex = {
      includes = [
        "^\\Qscala/util/Try#get().\\E$",
        "^\\Qscala/util/Success#get().\\E$",
        "^\\Qscala/util/Failure#get().\\E$"
      ]
    }
    id = "Try.get"
    message = """
      Do not use Try.get(). It can throw an exception in case of failure.
      To disable this error you can use:
        - @SuppressWarnings(Array("scalafix:Disable.Try.get"))
        - // scalafix:ok Disable.Try.get
    """
  }
  {
    regex = "^\\Qscala/collection/mutable\\E.*$"
    id = "scala.collection.mutable"
    message = """
      If you want to use mutable collections it is better to use Java collections instead, they have a better performance.
      To disable this error you can use:
        - @SuppressWarnings(Array("scalafix:Disable.scala.collection.mutable"))
        - // scalafix:ok Disable.scala.collection.mutable
    """
  }
  {
    regex = "^\\Qscala/collection/parallel\\E.*$"
    id = "scala.collection.parallel"
    message = """
      Parallel collections do not perform very well and block the thread, prefer cats' Parallel (https://typelevel.org/cats/typeclasses/parallel.html).
      To disable this error you can use:
        - @SuppressWarnings(Array("scalafix:Disable.scala.collection.parallel"))
        - // scalafix:ok Disable.scala.collection.parallel
    """
  }
  {
    regex = "^\\Qscala/math/Big\\E.*$"
    id = "scala.math"
    message = """
      Scala arbitrary precision numbers are broken (https://github.com/scala/bug/issues/9670).
      To disable this error you can use:
        - @SuppressWarnings(Array("scalafix:Disable.scala.math"))
        - // scalafix:ok Disable.scala.math
    """
  }
  {
    regex = {
      includes = [
        "^\\Qjava/io\\E.*$"
        "^\\Qscala/io/Source\\E.*$"
      ]
    }
    id = "blocking.io"
    message = """
      This is a legacy blocking API, prefer `java.nio`.
      To disable this error you can use:
        - @SuppressWarnings(Array("scalafix:Disable.blocking.io"))
        - // scalafix:ok Disable.blocking.io
    """
  }
  {
    regex = "^\\Qjava/net/URL#\\E.*$"
    id = "URL"
    message = """
      URL talks to the network for equality, prefer URI.
      To disable this error you can use:
        - @SuppressWarnings(Array("scalafix:Disable.URL"))
        - // scalafix:ok Disable.URL
    """
  }
  {
    regex = "^.*\\Q#equals().\\E$"
    id = "equals"
    message = """
      Prefer using cats' Eq typeclass (https://typelevel.org/cats/typeclasses/eq.html).
      To disable this error you can use:
        - @SuppressWarnings(Array("scalafix:Disable.equals"))
        - // scalafix:ok Disable.equals
    """
  }
  {
    regex = "^.*\\Q#hashCode().\\E$"
    id = "hashCode"
    message = """
      Prefer using cats' Hash typeclass (https://github.com/typelevel/cats/blob/master/kernel/src/main/scala/cats/kernel/Hash.scala).
      To disable this error you can use:
        - @SuppressWarnings(Array("scalafix:Disable.hashCode"))
        - // scalafix:ok Disable.hashCode
    """
  }
  {
    regex = "^.*\\Q#toString().\\E$"
    id = "toString"
    message = """
      Prefer using cats' Show typeclass (https://typelevel.org/cats/typeclasses/show.html).
      To disable this error you can use:
        - @SuppressWarnings(Array("scalafix:Disable.toString"))
        - // scalafix:ok Disable.toString
    """
  }
  {
    symbol = "scala/Enumeration"
    id = "Enumeration"
    message = """
      Prefer a sealed abstract class or Enumeratum (https://github.com/lloydmeta/enumeratum).
      To disable this error you can use:
        - @SuppressWarnings(Array("scalafix:Disable.Enumeration"))
        - // scalafix:ok Disable.Enumeration
    """
  }
  {
    regex = {
      includes = [
        "^\\Qscala/collection/IterableLike#head().\\E$",
        "^\\Qscala/collection/GenTraversableLike#head().\\E$",
        "^\\Qscala/collection/LinearSeqOptimized#head().\\E$",
        "^\\Qscala/collection/IndexedSeqOptimized#head().\\E$",
        "^\\Qscala/collection/TraversableLike#head().\\E$"
      ]
    }
    id = "head"
    message = """
      Try not to use `head`, it is not a total function.
      To disable this error you can use:
        - @SuppressWarnings(Array("scalafix:Disable.head"))
        - // scalafix:ok Disable.head
    """
  }
  {
    regex = {
      includes = [
        "^\\Qscala/collection/IterableLike#last().\\E$",
        "^\\Qscala/collection/GenTraversableLike#last().\\E$",
        "^\\Qscala/collection/LinearSeqOptimized#last().\\E$",
        "^\\Qscala/collection/IndexedSeqOptimized#last().\\E$",
        "^\\Qscala/collection/TraversableLike#last().\\E$"
      ]
    }
    id = "last"
    message = """
      Try not to use `last`, it is not a total function.
      To disable this error you can use:
        - @SuppressWarnings(Array("scalafix:Disable.last"))
        - // scalafix:ok Disable.last
    """
  }
  {
    symbol = "scala/Predef/println"
    id = "println"
    message = """
      Try not to use `println`, use a logger instead.
      To disable this error you can use:
        - @SuppressWarnings(Array("scalafix:Disable.println"))
        - // scalafix:ok Disable.println
    """
  }
]

Disable.ifSynthetic = [
  "scala/Option.option2Iterable"
  "scala/Predef.any2stringadd"
  {
    regex = {
      includes = [
        "^\\Qscala/collection/MapLike#apply().\\E$"
        "^\\Qscala/collection/LinearSeqOptimized#apply().\\E$"
      ]
    }
    id = "collection.apply"
    message = """
      Try not to use apply method from collections, it is not a total function.
      To disable this error you can use:
        - @SuppressWarnings(Array("scalafix:Disable.collection.apply"))
        - // scalafix:ok Disable.collection.apply
    """
  }
]

DisableSyntax {
  noAsInstanceOf = true
  noContravariantTypes = true
  noCovariantTypes = true
  noDefaultArgs = true
  noFinalVal = true
  noFinalize = true
  noImplicitConversion = true
  noImplicitObject = true
  noIsInstanceOf = true
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

import java.io.File
import java.net.URL

import scala.io.Source
import scala.math.BigDecimal
import scala.math.BigInt
import scala.util.Failure
import scala.util.Success
import scala.util.Try

object Disable {

  object symbols {

    Left(42).left.get   // assert: Disable.Either.get
    Right(42).right.get // assert: Disable.Either.get

    Option(42).get // assert: Disable.Option.get
    Some(42).get   // assert: Disable.Option.get
    None.get       // assert: Disable.Option.get

    Try(42).get                               // assert: Disable.Try.get
    Success(42).get                           // assert: Disable.Try.get
    Failure(new IllegalArgumentException).get // assert: Disable.Try.get

    BigDecimal("1.1") // assert: Disable.scala.math
    BigInt("42")      // assert: Disable.scala.math

    new File(".")             // assert: Disable.blocking.io
    Source.fromString("miau") // assert: Disable.blocking.io

    new URL("https://example.com") // assert: Disable.URL

    42.equals(42) // assert: Disable.equals

    42.hashCode() // assert: Disable.hashCode

    42.toString // assert: Disable.toString

    object WeekDay extends Enumeration { // assert: Disable.Enumeration
      val Mon, Tue, Wed, Thu, Fri, Sat, Sun = Value
    }

    println("Hello World!") // assert: Disable.println

  }

}
