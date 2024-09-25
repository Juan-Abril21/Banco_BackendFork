pipeline {
    agent any
    stages {
        stage('Clean Gradle Daemons') {
            steps {
                sh 'gradle --stop'
            }
        }
        stage('Build') {
            steps {
                sh './gradlew build'
            }
        }
    }
}
