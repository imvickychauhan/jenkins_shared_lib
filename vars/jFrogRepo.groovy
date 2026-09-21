def call() {

    withCredentials([
        usernamePassword(
            credentialsId: 'jfrog-credentials',
            usernameVariable: 'JFROG_USER',
            passwordVariable: 'JFROG_PASSWORD'
        )
    ]) {

        sh '''
            jf config add jfrog-local \
                --url=http://172.24.5.38:8082 \
                --user="$JFROG_USER" \
                --password="$JFROG_PASSWORD" \
                --interactive=false

            jf rt upload \
                "target/*.jar" \
                "libs-release-local/"
        '''
    }
}
