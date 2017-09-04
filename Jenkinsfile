

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
	        sh 'docker run -d -p 8081:8080 martinmagakian/todolist'
	     }
	}

