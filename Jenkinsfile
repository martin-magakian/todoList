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
    	label any
    }

    stages {
        stage('build') {
            steps {
                sh 'mvn package'
            }
        }
    }
}
