/*pipeline {
    agent { docker 'maven:3.3.3' }
    stages {
        stage('build') {
            steps {
                sh 'mvn package'
            }
        }
    }
}*/



pipeline {
    agent { s
    	node { 
    		label 'java8'
    	}
    }
    tools {
    	maven 'maven 3.3.9'
    }

    stages {
        stage('build') {
            steps {
                sh 'mvn package'
            }
        }
    }
}
