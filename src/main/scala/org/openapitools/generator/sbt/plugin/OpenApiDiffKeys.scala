package org.openapitools.generator.sbt.plugin

import org.openapitools.openapidiff.core.model.ChangedOpenApi
import org.openapitools.openapidiff.core.output.Render
import sbt._

trait OpenApiDiffKeys {

  final val openApiDiffFiles = taskKey[(File, File)]("OpenAPI specification files to diff.")
  final val openApiDiff = taskKey[ChangedOpenApi]("Returns the diff between two OpenAPI specifications.")

  final val openApiDiffRenderer = settingKey[Render]("OpenAPI specification diff renderer.")
  final val openApiDiffRender = taskKey[String]("Returns the rendered diff between two OpenAPI specifications.")

}
