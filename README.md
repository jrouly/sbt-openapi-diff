# sbt-openapi-diff

[![Scala CI](https://github.com/jrouly/sbt-openapi-diff/workflows/Scala%20CI/badge.svg?branch=master)](https://github.com/jrouly/sbt-openapi-diff/actions?query=workflow%3A%22Scala+CI%22)

An sbt plugin to support the [OpenAPI Diff](https://github.com/OpenAPITools/openapi-diff) project.

# Usage

Add to your `project/plugins.sbt`:

```sbt
addSbtPlugin("net.rouly" % "sbt-openapi-diff" % "version")
```

Update your `build.sbt`:
```sbt
enablePlugins(OpenApiDiffPlugin)
openApiDiffFiles := (file("openapi.v1.yaml"), file("openapi.v2.yaml"))
```

Invoke one of the provided tasks:
```
> openApiDiff
> openApiDiffRender
```

#### Changing the renderer

You can change how the diff is rendered by setting `openApiDiffRenderer`:
```sbt
import org.openapitools.openapidiff.core.output._
openApiDiffRenderer := new MarkdownRender()
openApiDiffRenderer := new HtmlRender()
openApiDiffRenderer := new ConsoleRender()
```

#### Extensions

See the [openapi-diff](https://github.com/OpenAPITools/openapi-diff#extensions) documentation for details on writing diff extensions.

# sbt keys

| Key | Type | Description |
| ------- | ---- | ----------- |
| `openApiDiffFiles` | `TaskKey[(sbt.File, sbt.File)]` | OpenAPI specification files to diff. |
| `openApiDiff` | `TaskKey[ChangedOpenApi]` | Returns the diff between two OpenAPI specifications. |
| `openApiDiffRenderer` | `SettingKey[Render]` | OpenAPI specification diff renderer. |
| `openApiDiffRender` | `TaskKey[String]` | Returns the rendered diff between two OpenAPI specifications. |

# Examples

Please see [an sbt-test configuration](src/sbt-test) for examples of using the plugin.
Do not run those examples directly, please copy them to separate place first.

# Contribution and testing

Write plugin integration tests under [src/sbt-test](src/sbt-test).

Execute next command to run tests:

```shell script
sbt scripted
```

More information about how to write and execute tests [is here](https://www.scala-sbt.org/1.x/docs/Testing-sbt-plugins.html).

# Credits

Based heavily on [sbt-openapi-generator](https://github.com/OpenAPITools/sbt-openapi-generator).
