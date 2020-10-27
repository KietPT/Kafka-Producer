pipeline {
    agent any
    tools {
        maven 'Maven-3.6.3'
    }
    options {
      buildDiscarder(logRotator(numToKeepStr: '20', artifactNumToKeepStr: '20'))
    }
    stages {   
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
