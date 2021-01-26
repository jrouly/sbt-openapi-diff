name := "sbt-openapi-diff"
organization := "org.openapitools.openapidiff"
description := "Supports functionality from openapi-diff as part of an sbt build."

licenses += ("The Apache Software License, Version 2.0", url("https://www.apache.org/licenses/LICENSE-2.0.txt"))

homepage := Some(url("https://github.com/jrouly/sbt-openapi-diff"))

developers += Developer(
  id = "jrouly",
  name = "Jean Michel Rouly",
  email = "michel@rouly.net",
  url = url("https://github.com/jrouly")
)

scmInfo := Some(
  ScmInfo(
    browseUrl = url("https://github.com/jrouly/sbt-openapi-diff"),
    connection = "scm:git:git://github.com/jrouly/sbt-openapi-diff.git",
    devConnection = "scm:git:ssh://git@github.com:jrouly/sbt-openapi-diff.git"
  )
)

enablePlugins(SbtPlugin)
sbtPlugin := true
crossSbtVersions := List("0.13.18", "1.4.6")

libraryDependencies += "org.openapitools.openapidiff" % "openapi-diff-core" % "2.0.0-beta.6"

publishMavenStyle := false

bintrayRepository := "sbt-plugins"
bintrayOrganization := Option("jrouly")
bintrayPackageLabels := Seq("sbt", "plugin", "oas", "openapi", "openapi-diff")
bintrayVcsUrl := Some("git@github.com:jrouly/sbt-openapi-diff.git")

scriptedBufferLog := false
scriptedLaunchOpts := {
  scriptedLaunchOpts.value ++ Seq("-Xmx1024M", "-server", "-Dplugin.version=" + version.value)
}
