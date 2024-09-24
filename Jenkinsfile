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
                // Compile the component and fail the build if it doesn't compile
                script {
                    try {
                        // Intentar compilar el proyecto
                        sh 'mvn clean compile' // Por ejemplo, en Java con Maven
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
