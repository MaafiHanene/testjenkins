pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        bat 'gradle uploadArchives'
      }
    }
    stage('Mail Notification') {
      steps {
        mail(subject: 'Build jenkins', body: 'New Integration Notification', to: 'fh_maafi@esi.dz', from: 'jenkins-notifications@jenkins.com')
      }
    }
    stage('Code Analysis') {
      environment {
        scannerHome = tool 'SonarQubeScanner'
    }
      steps {
        withSonarQubeEnv('sonarqube') {
          bat "sonar-scanner"
        }
        timeout(time: 10, unit: 'MINUTES') {
            waitForQualityGate abortPipeline: true
        }
    }

      }
    
  }
}
