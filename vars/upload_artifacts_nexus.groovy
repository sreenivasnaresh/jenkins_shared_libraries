def call(){
  def pom = readMavenPom file: 'pom.xml'
   def ver = pom.version
   def repoName = 'doctor-online-release'
   if(ver.endsWith("SNAPSHOT")){
     repoName = 'doctor-online-snapshot'                        
   }
   nexusArtifactUploader artifacts: [[artifactId: 'doctor-online', 
     classifier: '', 
     file: 'target/doctor-online.war',
     type: 'war']],
     credentialsId: 'nexus3', 
     groupId: 'in.javahome',
     nexusUrl: env.nexus_url,
     nexusVersion: 'nexus3',
     protocol: 'http',
     repository: repoName,
     version: ver
}
