pipeline {
    agent any
    
    stages {
        stage('Preparation') {
           // Get some code from the branch sending the webhook in GitHub 
           git 'https://github.com/KietPT/Kafka-Producer.git'
        }
        stage('Build') {
            steps {
                echo "Test abc trigger"
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
