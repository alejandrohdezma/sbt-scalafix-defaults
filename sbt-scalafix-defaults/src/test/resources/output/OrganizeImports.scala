import java.util.ArrayList
import java.util.UUID

import scala.concurrent.duration._
import scala.math.abs
import scala.math.acos

import cats.Show
import cats.implicits._
import cats.kernel.Eq
import cats.kernel.Hash

import sbt.Def
import sbt.Keys

import com.sun.crypto.provider.RSACipher

object OrganizeImports