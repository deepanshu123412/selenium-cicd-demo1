pipeline {
    agent any

    stages {
        // Checkout the code from the Git repository
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/deepanshu123412/selenium-cicd-demo1.git'
            }
        }

        // Build and run tests using Maven
        stage('Build and Run Tests') {
            steps {
                bat 'mvn clean test' // Use 'sh' if Jenkins is on a Unix-based OS
            }
        }

        // Publish the ExtentReports HTML to Jenkins
        stage('Publish Report') {
            steps {
                publishHTML([ 
                    reportDir: 'target/ExtentReports', // Directory where reports are located
                    reportFiles: 'index.html',          // The main report file to display
                    reportName: 'Extent Reports'        // The name that will appear in Jenkins UI
                ])
            }
        }
    }

    post {
        // Send an email on build success
        success {
            emailext(
                to: 'deepanshu821@gmail.com',
                subject: "Build Successful",
                body: "Tests ran successfully. Please view the Extent Reports in Jenkins."
            )
        }

        // Send an email on build failure
        failure {
            emailext(
                to: 'deepanshu821@gmail.com',
                subject: "Build Failed",
                body: "Tests failed. Check Jenkins console logs for errors."
            )
        }
    }
}
