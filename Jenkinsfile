pipeline {
    agent any
    stages {
        stage('kill Gradle Daemons') {
            steps {
                sh 'kill 5876'
            }
        }
        stage('Clean Gradle Daemons') {
            steps {
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
