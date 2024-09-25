pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/Juan-Abril21/Banco_BackendFork.git'
            }
        }
        stage('gradle status') {
            steps {
                sh 'gradle --status'
            }
        }

        stage('Build') {
            steps {
                sh './gradlew build'
            }
        }
    }
}
