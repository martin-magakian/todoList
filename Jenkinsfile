
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
		sh 'docker run -d --name todolist -p 8081:8080 martinmagakian/todolist'
	}
	stage('deploy (prod)') {
		// enable remote api http://vcommunique.blogspot.fr/2017/02/enabling-docker-remote-api-on-ubuntu.html
		sh 'docker -H remoteURL:port rm -f todolist | true'
		sh 'docker -H remoteURL:port run -d --name todolist -p 8081:8080 martinmagakian/todolist'
	}
}

