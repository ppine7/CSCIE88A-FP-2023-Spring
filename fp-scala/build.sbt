import Dependencies._
import sbt.io.{ FileFilter, IO, Path }

lazy val root = (project in file(".")).settings(
  inThisBuild(
    List(
      organization := "com.cscie88a",
      scalaVersion := "2.13.10"
    )
  ),
  name := "fp-scala-homework",
  scalacOptions ++= Seq(
    "-feature",
    "-deprecation",
    "-unchecked",
    "-language:postfixOps",
    "-language:higherKinds", // HKT required for Monads and other HKT types
  ),
  libraryDependencies ++= Dependencies.core ++ Dependencies.scalaTest,
  assembly / mainClass := Some("com.cscie88a.MainApp"),
  assembly / assemblyJarName := "fp-scala-homework.jar",
  assembly / test := {},
  // ignore lib refs in jars
  assembly / assemblyMergeStrategy:= {
    case PathList("META-INF", xs @ _*) => MergeStrategy.discard
    case x =>
      val oldStrategy = (assembly / assemblyMergeStrategy).value
      oldStrategy(x)
  }
)

lazy val zipHomework = taskKey[Unit]("zip files for homework submission")

zipHomework := {
  val bd = baseDirectory.value
  val targetFile = s"${bd.getAbsolutePath}/scalaHomework.zip"
  val ignoredPaths =
    ".*(\\.idea|target|\\.DS_Store|\\.bloop|\\.metals|\\.vsc)/*".r.pattern
  val fileFilter = new FileFilter {
    override def accept(f: File) =
      !ignoredPaths.matcher(f.getAbsolutePath).lookingAt
  }
  println("zipping project files ...")
  IO.delete(new File(targetFile))
  IO.zip(
    Path.selectSubpaths(new File(bd.getAbsolutePath), fileFilter),
    new File(targetFile),
    None
  )
}
