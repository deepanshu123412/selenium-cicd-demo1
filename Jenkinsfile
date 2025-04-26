pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                git 'https://github.com/deepanshu123412/selenium-sample.git'
            }
        }
        stage('Build and Run Tests') {
            steps {
                bat 'mvn clean test'
            }
        }
        stage('Publish Report') {
            steps {
                archiveArtifacts artifacts: '**/ExtentReports/*.html', allowEmptyArchive: true
            }
        }
    }

    post {
        success {
            mail to: 'deepanshu821@gmail.com',
                 subject: "Build Successful",
                 body: "Tests ran successfully. Please check the attached Extent Report."
        }
        failure {
            mail to: 'deepanshu821@gmail.com',
                 subject: "Build Failed",
                 body: "Tests failed. Check Jenkins for details."
        }
    }
}
