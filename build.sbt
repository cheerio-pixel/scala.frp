name := "scala-frp"

organization := "io.dylemma"

version := "1.4"

scalaVersion := "2.13.16"

crossScalaVersions := Seq("2.13.16", "3.3.5")

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-parallel-collections" % "1.2.0",
  "org.scalatest" %% "scalatest" % "3.2.19" % Test,
)

scalacOptions in Compile += "-deprecation"

scalacOptions in (Compile, doc) += "-implicits"

// publishing stuff below

publishMavenStyle := true

publishTo := {
	val nexus = "https://oss.sonatype.org/"
	if(isSnapshot.value)
		Some("snapshots" at nexus + "content/repositories/snapshots")
	else
		Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
        <url>https://github.com/dylemma/scala.frp</url>
	<licenses>
		<license>
			<name>MIT License</name>
			<url>http://opensource.org/licenses/mit-license.php</url>
			<distribution>repo</distribution>
		</license>
	</licenses>
	<scm>
		<url>git@github.com:dylemma/scala.frp.git</url>
		<connection>scm:git:git@github.com:dylemma/scala.frp.git</connection>
	</scm>
	<developers>
		<developer>
			<id>dylemma</id>
			<name>Dylan Halperin</name>
			<url>http://dylemma.io/</url>
		</developer>
	</developers>
)