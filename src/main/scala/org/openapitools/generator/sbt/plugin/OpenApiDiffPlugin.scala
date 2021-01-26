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
