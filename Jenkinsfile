node {
    stage('SCM Checkout') {    
        git 'https://github.com/KietPT/Kafka-Producer'
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
