pipeline {
    agent any
    stages {
        stage('Clean Gradle Daemons') {
            steps {
                sh './gradlew kill 5876'
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
