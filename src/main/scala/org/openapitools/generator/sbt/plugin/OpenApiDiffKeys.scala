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

import org.openapitools.openapidiff.core.model.ChangedOpenApi
import org.openapitools.openapidiff.core.output.Render
import sbt._

trait OpenApiDiffKeys {

  final val openApiDiffFiles = taskKey[(File, File)]("OpenAPI specification files to diff.")
  final val openApiDiff = taskKey[ChangedOpenApi]("Returns the diff between two OpenAPI specifications.")

  final val openApiDiffRenderer = settingKey[Render]("OpenAPI specification diff renderer.")
  final val openApiDiffRender = taskKey[String]("Returns the rendered diff between two OpenAPI specifications.")

}
