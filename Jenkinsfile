pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        
        bat 'gradle build'
        bat 'gradle generateMatrixAPI'
      }
      post { 
        failure {
          mail(subject: 'Build jenkins', body: 'Build Failure', to: 'fh_maafi@esi.dz', from: 'jenkins-notifications@jenkins.com')
        }
      }
    }
    stage('Mail Notification') {
      steps {
        mail(subject: 'Build jenkins', body: 'Build Success', to: 'fh_maafi@esi.dz', from: 'jenkins-notifications@jenkins.com')
      }
    }
    stage('Code Analysis') {
      parallel {
        stage('Code Analysis') {
          environment {
            scannerHome = tool'SonarQubeScanner'
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
      when {
        branch 'master'
      }
      steps {
        bat 'gradle uploadArchives'
      }
    }
    stage('Slack Notification') {
      when {
        branch 'master'
      }
      steps {
        slackSend(channel: 'integration_jenkins', message: 'Integration Success')
      }
    }
  }
}
