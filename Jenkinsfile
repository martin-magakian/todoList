

	pipeline {
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
	        stage('Push') {
	            steps {
	                app = docker.build("getintodevops/hellonode")
	                docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
			            app.push("latest")
			        }
	            }
	        }
		   //post {
		   //    failure {
		   //        mail to: team@example.com, subject: 'The Pipeline failed :('
		   //    }
		   //}
	    }
	}



