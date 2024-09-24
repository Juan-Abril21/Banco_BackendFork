pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Clonar el repositorio
                git url: 'https://github.com/Juan-Abril21/Banco_BackendFork.git', branch: 'master'
            }
        }
        stage('Build') {
            steps {
                // Ejecutar la compilación con Gradle
                sh './gradlew build'
            }
        }
    }
}
