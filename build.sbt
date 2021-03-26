name := "sbt-openapi-diff"
organization := "org.openapitools.openapidiff"
description := "Supports functionality from openapi-diff as part of an sbt build."

homepage := Some(url("https://github.com/jrouly/sbt-openapi-diff"))
licenses := Seq("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0"))

scriptedBufferLog := false
scriptedLaunchOpts ++= Seq("-Xmx1024M", "-server", "-Dplugin.version=" + version.value)

Global / onChangedBuildSource := ReloadOnSourceChanges

enablePlugins(SbtPlugin)
sbtPlugin := true

crossSbtVersions := List(
  "0.13.18",
  "1.1.6" // https://github.com/sbt/sbt/issues/5049
)

libraryDependencies += "org.openapitools.openapidiff" % "openapi-diff-core" % "2.0.0-beta.6"

credentials += Credentials(
  "Artifactory Realm",
  "jrouly.jfrog.io",
  sys.env.getOrElse("ARTIFACTORY_USER", "user"),
  sys.env.getOrElse("ARTIFACTORY_PASS", "pass")
)

publishMavenStyle := false
publishTo := {
  def resolver(host: String, repo: String) =
    Resolver.url(repo, url(s"https://$host/artifactory/$repo"))(Resolver.ivyStylePatterns)
  if (isSnapshot.value) Some(resolver("jrouly.jfrog.io", "ivy-snapshot-local"))
  else Some(resolver("jrouly.jfrog.io", "ivy-release-local"))
}
