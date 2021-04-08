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

import cats.kernel.{Eq, Hash}
import cats.Show
import cats.implicits._
import sbt.{Def, Keys}
import scala.math.{abs, acos}
import com.sun.crypto.provider.RSACipher
import scala.concurrent.duration._
import java.util.UUID
import java.util.ArrayList

object OrganizeImports