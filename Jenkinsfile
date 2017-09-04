// pipeline {	
//     agent {
//     	docker 'maven:3.3.3'
//     }
// 
//     stages {
//         stage('pre-build') {
//             steps {
//                 sh 'echo "do stuff before build"'
//             }
//         }
//         stage('build') {
//             steps {
//                 sh 'mvn package'
//             }
//         }
//         stage('Archive') {
//             steps {
//                 junit(testResults: '**/target/**/TEST*.xml', allowEmptyResults: true)
//             }
//         }
// 
// 
//     }
// }


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
     stage('Docker') {
        def app = docker.build("martinmagakian/todolist")
        docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
            app.push("latest")
        }
     }
}
