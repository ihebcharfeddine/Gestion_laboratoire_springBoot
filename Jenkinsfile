pipeline {
    agent any

    environment {
        SONARQUBE_URL = 'http://192.168.8.132:9000'  // URL de SonarQube
        SONARQUBE_TOKEN = credentials('sonar_access_token') // Récupération du token SonarQube via les Credentials
        MAVEN_HOME = '/opt/maven'                     // Chemin Maven si nécessaire
    }

    tools {
        maven 'M398'     
        jdk 'JDK 11'    
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/ihebcharfeddine/Gestion_laboratoire_springBoot.git'
            }
        }

        stage('Build & SonarQube Analysis') {
            steps {
                script {
                    def services = ['config-service', 'evenement-service', 'gateway', 'membre-service', 'outil-service', 'publication-service', 'registry-service']

                    for (service in services) {
                        dir(service) { // Aller dans chaque dossier
                            echo "Building and analyzing ${service}..."

                            // Compilation Maven
                            sh "mvn clean install -DskipTests"

                            // Analyse SonarQube
                            sh """
                                mvn sonar:sonar \
                                    -Dsonar.projectKey=${service} \
                                    -Dsonar.host.url=${env.SONARQUBE_URL} \
                                    -Dsonar.login=${env.SONARQUBE_TOKEN} \
                                    -Dsonar.java.binaries=target/classes
                            """
                        }
                    }
                }
            }
        }
    }

    post {
        success {
            echo '✅ Build et analyse SonarQube réussis pour tous les microservices !'
        }
        failure {
            echo '❌ Une erreur s\'est produite pendant le build ou l\'analyse SonarQube.'
        }
    }
}
