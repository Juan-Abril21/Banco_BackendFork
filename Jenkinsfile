pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the repository
                checkout scm
            }
        }

        stage('Compile') {
            steps {
                script {
                    try {
                        // Ejecuta el comando de compilación de Gradle
                        sh './gradlew build' // Ejecuta el build con Gradle
                        echo 'Compilación exitosa.'
                    } catch (Exception e) {
                        echo 'Error de compilación.'
                        error('La compilación ha fallado. Revisa los logs.')
                    }
                }
            }
        }
    }

    post {
        success {
            // Publica el resultado exitoso en GitHub
            publishChecks name: 'Compile', summary: 'Compilación exitosa', conclusion: 'SUCCESS'
        }
        failure {
            // Publica el resultado fallido en GitHub
            publishChecks name: 'Compile', summary: 'Compilación fallida', conclusion: 'FAILURE'
        }
    }
}
