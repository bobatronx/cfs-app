organization  := "com.example"

version       := "0.1"

scalaVersion  := "2.10.3"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

resolvers ++= Seq(
  "anormcypher" at "http://repo.anormcypher.org/",
  "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases/",
  "spray" at "http://repo.spray.io/"
)

libraryDependencies ++= {
  val akkaV = "2.3.0"
  val sprayV = "1.3.1"
  Seq(
    "io.spray"            %   "spray-can"     % sprayV,
    "io.spray"            %   "spray-routing" % sprayV,
    "io.spray"            %   "spray-testkit" % sprayV  % "test",
    "com.typesafe.akka"   %%  "akka-actor"    % akkaV,
    "com.typesafe.akka"   %%  "akka-testkit"  % akkaV   % "test",
    "org.specs2"          %%  "specs2-core"   % "2.3.7" % "test",
    "org.webjars" % "angularjs" % "1.3.0-beta.8",
    "org.webjars" % "requirejs" % "2.1.11",
    "org.webjars" % "bootstrap" % "3.1.1",
    "org.webjars" % "angular-strap" % "2.0.2",
    "org.webjars" % "requirejs-domready" % "2.0.1-1",
    "org.anormcypher"     %%  "anormcypher"   % "0.4.4",
    "io.spray" %%  "spray-json" % "1.2.6"
  )
}

Revolver.settings
