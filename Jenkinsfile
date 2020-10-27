pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                echo "Test abc trigger 1 kietpt"
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
