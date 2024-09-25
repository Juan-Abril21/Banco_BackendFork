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

        stage('Test') {
            steps {
                // Ejecuta las pruebas unitarias con Gradle
                sh './gradlew test'
            }
        }
    }

    post {
        success {
            // Si todo va bien, notifica el éxito en GitHub
            echo 'Build y pruebas exitosas.'
        }
        failure {
            // Si hay un fallo, también lo reporta
            echo 'El build falló. No se puede realizar el merge.'
        }
    }
}
