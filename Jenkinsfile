pipeline {
    agent any
    stages {
        stage('Clean Gradle Daemons') {
            steps {
                sh './gradlew --stop'
            }
        }
        stage('Build') {
            steps {
                sh './gradlew build'
            }
        }
    }
}
