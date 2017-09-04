

	pipeline {
		def app
	    agent {
	    	agent { docker 'maven:3.3.3' }
	    }

	    stages {
	        stage('pre-build') {
	            steps {
	                sh 'echo "do stuff before build"'
	            }
	        }
	        stage('build') {
	            steps {
	                sh 'mvn package'
	            }
	        }
	        stage('Archive') {
	            steps {
	                junit(testResults: '**/target/**/TEST*.xml', allowEmptyResults: true)
	            }
	        }

		   //post {
		   //    failure {
		   //        mail to: team@example.com, subject: 'The Pipeline failed :('
		   //    }
		   //}
	    }
	}



