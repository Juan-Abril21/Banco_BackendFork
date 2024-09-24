pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Clonar el repositorio
                git url: 'https://github.com/usuario/proyecto.git', branch: 'develop'
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