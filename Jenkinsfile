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
    }
}
