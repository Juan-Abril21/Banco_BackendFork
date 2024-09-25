pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Clona el repositorio
                git branch: 'master', url: 'https://github.com/Juan-Abril21/Banco_BackendFork.git'
            }
        }

        stage('Build') {
            steps {
                // Ejecuta la compilación utilizando Gradle
                sh './gradlew build'
            }
        }
    }
}
