pipeline {
    agent any
    stages {
        stage('Clean Gradle Daemons') {
            steps {
                sh 'pkill -f gradle || true' 
                sh './gradlew --status'
            }
        }
        stage('Build') {
            steps {
                sh './gradlew build'
            }
        }
    }
}
