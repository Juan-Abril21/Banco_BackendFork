pipeline {
    agent any
    stages {
        stage('Clean Gradle Daemons') {
            steps {
                sh './gradlew ps -ef | grep gradle'
            }
        }
        stage('Build') {
            steps {
                sh './gradlew build'
            }
        }
    }
}
