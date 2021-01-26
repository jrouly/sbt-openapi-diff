/*
 * Copyright (c) 2020 OpenAPI-Generator Contributors (https://openapi-generator.tech)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openapitools.generator.sbt.plugin

import org.openapitools.openapidiff.core.OpenApiCompare
import org.openapitools.openapidiff.core.output.MarkdownRender
import sbt._
import sbt.plugins.JvmPlugin

object OpenApiDiffPlugin extends sbt.AutoPlugin with OpenApiDiffKeys {
  self =>

  override def requires: JvmPlugin.type = sbt.plugins.JvmPlugin

  override def trigger: sbt.PluginTrigger = noTrigger

  object autoImport extends OpenApiDiffKeys

  override lazy val projectSettings: Seq[Def.Setting[_]] = Seq(
    openApiDiffFiles := {
      sys.error("openApiDiffFiles is undefined. Did you forget to set it?")
    },
    openApiDiff := {
      val (doc1, doc2) = openApiDiffFiles.value
      OpenApiCompare.fromFiles(doc1, doc2)
    },
    openApiDiffRenderer := new MarkdownRender(),
    openApiDiffRender := {
      val diff = openApiDiff.value
      val renderer = openApiDiffRenderer.value
      renderer.render(diff)
    }
  )
}
