pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                git 'https://github.com/deepanshu123412/selenium-cicd-demo1.git'
            }
        }
        stage('Build and Run Tests') {
            steps {
                bat 'mvn clean test' // Use sh if Jenkins is Linux
            }
        }
        stage('Publish Report') {
            steps {
                publishHTML([
                    reportDir: 'target/ExtentReports', 
                    reportFiles: 'index.html', 
                    reportName: 'Extent Reports'
                ])
            }
        }
    }

    post {
        success {
            emailext (
                to: 'deepanshu821@gmail.com',
                subject: "Build Successful",
                body: "Tests ran successfully. Please view the Extent Reports in Jenkins."
            )
        }
        failure {
            emailext (
                to: 'deepanshu821@gmail.com',
                subject: "Build Failed",
                body: "Tests failed. Check Jenkins console logs for errors."
            )
        }
    }
}
