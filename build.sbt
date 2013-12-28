name := "scalacheckSpecs2Scalaz"

description := "show issue with weird ScalaCheck dependencies"

libraryDependencies in ThisBuild ++= Seq(
  "org.scalaz"                        %% "scalaz-core"               % "7.0.5"
, "org.scalaz"                        %% "scalaz-scalacheck-binding" % "7.0.5"  % "test" excludeAll(ExclusionRule(organization = "org.scalacheck", artifact="scalacheck_2.10"))
, "org.specs2"                        %% "specs2"                    % "2.3.6"  % "test" excludeAll(ExclusionRule(organization = "org.scalacheck", artifact="scalacheck_2.10"))
, "org.scalacheck"                    %% "scalacheck"                % "1.11.1" % "test"
, "junit"                              % "junit"                     % "4.11"   % "test"
)
