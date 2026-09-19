def call(){
    // This looks up the Java installation and dynamically injects its path
    withEnv(["JAVA_HOME=${tool 'jdk8'}"]) {
        sh 'mvn clean install -DskipTests -U'
    }
}
