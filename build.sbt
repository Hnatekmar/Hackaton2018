name := "ChatBot"

version := "1.0"

scalaVersion := "2.12.4"

resolvers += Resolver.jcenterRepo

libraryDependencies ++= Seq(
  "com.twitter" %% "finatra-http" % "2.13.0"
)