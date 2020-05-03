import java.io.File
import java.net.URL

import scala.collection.mutable
import scala.collection.parallel
import scala.io.Source
import scala.math.BigDecimal
import scala.math.BigInt
import scala.util.Failure
import scala.util.Success
import scala.util.Try

object Disable {

  object symbols {

    Left(42).left.get // assert: Disable.Either.get
    Right(42).right.get // assert: Disable.Either.get

    Option(42).get // assert: Disable.Option.get
    Some(42).get // assert: Disable.Option.get
    None.get // assert: Disable.Option.get

    Try(42).get // assert: Disable.Try.get
    Success(42).get // assert: Disable.Try.get
    Failure(new IllegalArgumentException).get // assert: Disable.Try.get

    mutable.MutableList(1, 2, 3) // assert: Disable.scala.collection.mutable
    mutable.HashMap(1 -> "one") // assert: Disable.scala.collection.mutable

    parallel.ParSeq(1, 2, 3) // assert: Disable.scala.collection.parallel
    parallel.ParMap(1 -> "one") // assert: Disable.scala.collection.parallel

    BigDecimal("1.1") // assert: Disable.scala.math
    BigInt("42") // assert: Disable.scala.math

    new File(".") // assert: Disable.blocking.io
    Source.fromString("miau") // assert: Disable.blocking.io

    new URL("https://example.com") // assert: Disable.URL

    42.equals(42) // assert: Disable.equals

    42.hashCode() // assert: Disable.hashCode

    42.toString // assert: Disable.toString

    object WeekDay extends Enumeration { // assert: Disable.Enumeration
      val Mon, Tue, Wed, Thu, Fri, Sat, Sun = Value
    }

    List(1, 2, 3).head // assert: Disable.head
    Array(1, 2, 3).head // assert: Disable.head

    List(1, 2, 3).last // assert: Disable.last
    Array(1, 2, 3).last // assert: Disable.last

    println("Hello World!") // assert: Disable.println

  }

  object ifSynthetic {

    Map(1 -> "one").apply(42) // assert: Disable.collection.apply
    List(1, 2, 3).apply(42) // assert: Disable.collection.apply

  }

}