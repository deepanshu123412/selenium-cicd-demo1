pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/deepanshu123412/selenium-cicd-demo.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn test'
            }
        }
    }
}
