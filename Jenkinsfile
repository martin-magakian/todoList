

	node {
	     stage('pre-build') {
	        sh 'echo "do stuff before build"'
	     }
	     stage('build') {
	        sh 'mvn package' // unit test & build if success
	     }
	     stage('Archive') {
	        junit(testResults: '**/target/**/TEST*.xml', allowEmptyResults: true)
	     }
	     stage('release') {
	        def app = docker.build("martinmagakian/todolist")
	        docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
	            app.push("latest")
	        }
	     }
	     stage('deploy') {
	     	sh 'docker rm -f todolist | true'
	        sh 'docker run -d --name todolist -p 8081:8080 martinmagakian/todolist'
	     }
	}

