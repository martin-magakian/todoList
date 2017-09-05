

	node {
		
		stage('checkout') {
			git "https://github.com/martin-magakian/todolist"
			sh 'echo "do stuff before build"'
		}
		stage('test') {
			sh 'mvn test'
			junit(testResults: '**/target/**/TEST*.xml', allowEmptyResults: true)
		}
		stage('build') {
			sh 'mvn package -DskipTests'
		}
		stage('release') {
			def app = docker.build("martinmagakian/todolist")
			def img = docker.image('martinmagakian/todolist').run("-p 8888:8080")
			sh 'sleep 10'
			img.stop()
			docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
				app.push("latest")
			}
		}
		stage('deploy (preprod)') {

		}
	}

