/*
 * Copyright 2020-2021 Alejandro Hernández <https://github.com/alejandrohdezma>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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