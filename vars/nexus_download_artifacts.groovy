def call(fileName,groupID,artiID){
  def pom = readMavenPom file: 'pom.xml'
  def ver = pom.version 
  def grpID =groupID.replace(".", "/")
  sh """
     curl -o ${fileName} -u $USERPASS -X GET "${env.nexus_url}/repository/doctor-online-release/${grpID}/${artiID}/${ver}/doctor-online-${ver}.war"
  """
}
