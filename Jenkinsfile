pipeline {
    agent any
    stages {
        stage('Clean Gradle Daemons') {
            steps {
                sh './gradlew --status'
                sh 'pkill -f gradle || true' 
            }
        }
        stage('Build') {
            steps {
                sh './gradlew build'
            }
        }
    }
}
