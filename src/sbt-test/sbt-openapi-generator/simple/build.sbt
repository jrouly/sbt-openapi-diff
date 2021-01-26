lazy val noop = project

lazy val same = project
  .enablePlugins(OpenApiDiffPlugin)
  .settings(openApiDiffFiles := (file("petstore.v1.yaml"), file("petstore.v1.yaml")))
  .settings(
    TaskKey[Unit]("check") := {
      if (openApiDiff.value.isDifferent) sys.error("OpenAPI specs were not the same")
      ()
    }
  )

lazy val incompatible = project
  .enablePlugins(OpenApiDiffPlugin)
  .settings(openApiDiffFiles := (file("petstore.v1.yaml"), file("petstore.v2.yaml")))
  .settings(
    TaskKey[Unit]("check") := {
      if (openApiDiff.value.isCompatible) sys.error("OpenAPI specs were compatible")
      ()
    }
  )