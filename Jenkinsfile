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
		def img = docker.image('martinmagakian/todolist').run("-p 8080:8080")
		try {
			sh 'mvn -Dtest=FunctionalTest test'
			img.stop()
			docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
				app.push("latest")
			}
		} catch(Exception ex) {
			img.stop()
			error('Fonctional test failed...')
		}
	}
	stage('deploy (preprod)') {
		sh 'docker rm -f todolist | true'
		sh 'docker run -d --name todolist -p 80:8080 martinmagakian/todolist'
	}
	stage('deploy (prod)') {
		sh 'docker -H 46.101.172.45:2375 rm -f todolist | true'
		sh 'docker -H 46.101.172.45:2375 pull martinmagakian/todolist'
		sh 'docker -H 46.101.172.45:2375 run -d --name todolist -p 80:8080 martinmagakian/todolist'
	}
}

