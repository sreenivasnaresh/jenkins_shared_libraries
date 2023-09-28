def call(fileName,groupID,artiID,nexusRepo){
  def pom = readMavenPom file: 'pom.xml'
  def ver = pom.version 
  def grpID =groupID.replace(".", "/")
  sh """
     curl -o ${fileName} -u $USERPASS -X GET "${env.nexus_url}/repository/${nexusRepo}/${grpID}/${artiID}/${ver}/doctor-online-${ver}.war"
  """
}
