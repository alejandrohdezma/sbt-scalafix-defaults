import java.util.ArrayList
import java.util.UUID

import scala.concurrent.duration._

import cats.Show
import cats.implicits._
import cats.kernel.Eq
import cats.kernel.Hash

object OrganizeImports {

  val eqString   = implicitly[Eq[String]]
  val hashString = implicitly[Hash[String]]
  val showString = implicitly[Show[String]]
  val oneMinute  = 1.minute
  val randomUUID = UUID.randomUUID()
  val myList     = new ArrayList[String]()

}
