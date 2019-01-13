pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        bat 'gradle uploadArchives'
      }
    }
    stage('Mail Notification') {
      parallel {
        stage('Mail Notification') {
          steps {
            mail(subject: 'Build jenkins', body: 'New Integration Notification', to: 'fh_maafi@esi.dz', from: 'jenkins-notifications@jenkins.com')
          }
        }
        stage('TestReporting') {
          steps {
            jacoco()
          }
        }
      }
    }
    stage('Code Analysis') {
      environment {
        scannerHome = 'SonarQubeScanner'
      }
      steps {
        withSonarQubeEnv('sonarqube') {
          bat "${scannerHome}\\sonar-scanner"
        }

        timeout(time: 1, unit: 'MINUTES') {
          waitForQualityGate true
        }

      }
    }
  }
}