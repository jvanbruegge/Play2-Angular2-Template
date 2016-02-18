name := """Play2-Angular2 template"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, SbtWeb)

resolvers += "Madoushi sbt-plugins" at "https://dl.bintray.com/madoushi/sbt-plugins/"

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  javaJpa,
  "org.hibernate" % "hibernate-entitymanager" % "4.3.9.Final",
  "com.typesafe.sbt" % "sbt-interface" % "0.13.9",
  "org.webjars" %% "webjars-play" % "2.4.0-2",
  "org.webjars.npm" % "angular2" % "2.0.0-beta.3",
  "org.webjars.npm" % "jquery" % "2.2.0",
  "org.webjars.npm" % "jquery-ui" % "1.10.5",
  "org.webjars.npm" % "es5-shim" % "4.5.2",
  "org.webjars.npm" % "es6-shim" % "0.34.2",
  "org.webjars.npm" % "systemjs" % "0.19.20",
  "org.webjars.npm" % "rxjs" % "5.0.0-beta.1",
  "org.webjars.npm" % "bootstrap" % "3.3.6"
)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

TypescriptKeys.target := "ES5"
TypescriptKeys.moduleKind := "System"
TypescriptKeys.moduleResolutionKind := "NodeJs"
TypescriptKeys.sourceMap := true
TypescriptKeys.emitDecoratorMetadata := true
TypescriptKeys.experimentalDecorators := true
TypescriptKeys.removeComments := false
TypescriptKeys.noImplicitAny := false

excludeFilter in TypescriptKeys.typescript := {
  val public = (baseDirectory.value / "node_modules").getCanonicalPath
  new SimpleFileFilter(_.getCanonicalPath startsWith public)
}

JsEngineKeys.engineType := JsEngineKeys.EngineType.Node

// Compile the project before generating Eclipse files, so that generated .scala or .class files for views and routes are present
EclipseKeys.preTasks := Seq(compile in Compile)

fork in run := true

fork in run := true