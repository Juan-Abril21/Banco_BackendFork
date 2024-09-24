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
            // Notifica a GitHub que la compilación fue exitosa
            githubCheckStatus(name: 'Compile', status: 'COMPLETED', conclusion: 'SUCCESS')
            echo 'La compilación fue exitosa.'
        }
        failure {
            // Notifica a GitHub que la compilación falló
            githubCheckStatus(name: 'Compile', status: 'COMPLETED', conclusion: 'FAILURE')
            echo 'La compilación falló. Notificando a GitHub.'
        }
    }
}
