pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/BryamDigar/Banco_BackendFork.git'
            }
        }
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
