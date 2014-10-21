/**
 * sbt-aspectj-nested - AspectJ for nested projects.
 *
 * Copyright (c) 2013-2014 Alexey Aksenov ezh@ezh.msk.ru
 * Based on aspectj-sbt-plugin by Typesafe
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sbt.aspectj

import java.io.File

package object nested {
  /** Entry point for the plugin in user's project. */
  def AspectJNested = Plugin.defaultSettings ++ Plugin.dependencySettings
  /** Entry point for the plugin in user's project with RT dependency. */
  def AspectJNestedRT = Plugin.defaultSettings ++ Plugin.dependencySettingsRT

  // export declarations for end user
  lazy val AJKey = Keys
  lazy val AJConf = Keys.AspectJConf

  /** Add to log message AspectJ prefix. */
  protected[nested] def logPrefix(name: String) = "[AspectJ nested:%s] ".format(name)

  case class Aspect(file: File, binary: Boolean)
  case class Mapping(in: File, aspects: Seq[Aspect], out: File)
}
