pipeline {
    agent {
    	label any
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
	    post {
	        failure {
	            mail to: team@example.com, subject: 'The Pipeline failed :('
	        }
	    }
    }
}



