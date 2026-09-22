def call(){
    sh '''
        echo "USER=$(whoami)"
        echo "JAVA_HOME=[$JAVA_HOME]"
        echo "PATH=[$PATH]"
        which java
        readlink -f $(which java)
        java -version
        which mvn
        mvn -version
        ls -ld "$JAVA_HOME"
        ls -l "$JAVA_HOME/bin/java"
        mvn clean install -DskipTests
    '''
}
