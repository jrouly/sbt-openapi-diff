# sbt-openapi-generator

[![Scala CI](https://github.com/jrouly/sbt-openapi-diff/workflows/Scala%20CI/badge.svg?branch=master)](https://github.com/jrouly/sbt-openapi-diff/actions?query=workflow%3A%22Scala+CI%22)
[![Download](https://api.bintray.com/packages/jrouly/sbt-plugins/sbt-openapi-diff/images/download.svg)](https://bintray.com/jrouly/sbt-plugins/sbt-openapi-diff/_latestVersion)


An sbt plugin to support the [OpenAPI Diff](https://github.com/OpenAPITools/openapi-diff) project.

# Usage

Add to your `project/plugins.sbt`:

```sbt
addSbtPlugin("org.openapitools" % "sbt-openapi-diff" % "version")
```

# Configuration

TBD

# Execution

```shell script
sbt openApiDiff
```

# Settings

| Setting | Type | Description |
| ------- | ---- | ----------- |
| tbd | tbd | tbd |

# Examples

Please see [an sbt-test configuration](src/sbt-test) for examples of using the plugin.
Do not run those examples directly, please copy them to separate place first.

# Contribution and Tests

Write plugin integration tests under [src/sbt-test](src/sbt-test)

Execute next command to run tests:

```shell script
sbt scripted
```

More information about how to write and execute tests [is here](https://www.scala-sbt.org/1.x/docs/Testing-sbt-plugins.html)
