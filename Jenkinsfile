

node {
     stage('pre-build') {
        sh 'echo "do stuff before build"'
     }
     stage('build') {
        sh 'mvn package'
     }
     stage('Archive') {
        junit(testResults: '**/target/**/TEST*.xml', allowEmptyResults: true)
     }
}
