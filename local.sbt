
val artifactory = "http://migotek.virtuslab.com:8081/artifactory"

val localSnapshots = s"$artifactory/simple/libs-snapshot-local/"

val localReleases = s"$artifactory/simple/libs-release-local/"

resolvers += "Local Snapshots" at localSnapshots

resolvers += "Local Releases" at localReleases

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

publishTo := {
  if (version.value.contains("SNAPSHOT")) {
    Some("Artifactory Realm" at localSnapshots)
  } else {
    Some("Artifactory Realm" at localReleases)
  }
}