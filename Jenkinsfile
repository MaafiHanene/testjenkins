pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        bat 'gradle build'
        bat 'gradle generateMatrixAPI'
      }
    }
    stage('Mail Notification') {
      steps {
        mail(subject: 'Build jenkins', body: 'New Integration Notification', to: 'fh_maafi@esi.dz', from: 'jenkins-notifications@jenkins.com')
      }
    }
    stage('Code Analysis') {
      parallel {
        stage('Code Analysis') {
          environment {
            scannerHome = tool 'SonarQubeScanner'
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
        stage('Test Reporting') {
          steps {
            jacoco()
          }
        }
      }
    }
    stage('Deployement') {
      if (env.CHANGE_ID) {
   
      }
      else {
        steps {
        bat 'gradle uploadArchives'
      }
      }
      
    }
    stage('Slack Notification') {
      if (env.CHANGE_ID) {
   
      }
      else {
        steps {
        slackSend()
      }
      }
      
    }
    
  }
}
