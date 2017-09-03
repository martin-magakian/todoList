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
    agent {
    	node { 
    		label 'mavenxx'
    	}
    }

    stages {
        stage('build') {
            steps {
                sh 'mvn package'
            }
        }
    }
}
