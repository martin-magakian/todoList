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
                junit 'reports/**/*.xml'
            }
        }
    }
}
