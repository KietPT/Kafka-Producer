pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                echo "Test abc"
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }   
}
