pipeline {
    agent any

    environment {
        SONARQUBE_URL = 'http://192.168.8.128:9000'  // URL de ton serveur SonarQube
        SONARQUBE_TOKEN = 'sqa_6ce93bc6292b5dd49e990ecafbc9a515215ac1fa'          // Remplace par ton token SonarQube
        MAVEN_HOME = '/opt/maven'                      // Définir le chemin de Maven si nécessaire
    }

    tools {
        maven 'M398'  // Choisis la version de Maven installée dans Jenkins
        jdk 'JDK 11'    
    }

    stages {
        stage('Checkout') {
            steps {
                // Récupère le code depuis GitHub
                git branch: 'main', url: 'https://github.com/ihebcharfeddine/Gestion_laboratoire_springBoot.git'
            }
        }

        stage('Build') {
            steps {
                // Compile le projet avec Maven
                sh "mvn clean install -DskipTests"
            }
        }

        stage('SonarQube Analysis') {
            steps {
                script {
                    // Lancement de l'analyse SonarQube
                    sh """
                        mvn sonar:sonar \
                            -Dsonar.projectKey=ton-projet-spring \
                            -Dsonar.host.url=${env.SONARQUBE_URL} \
                            -Dsonar.login=${env.SONARQUBE_TOKEN} \
                            -Dsonar.java.binaries=target/classes
                    """
                }
            }
        }

        stage('Post Build Actions') {
            steps {
                script {
                    // Si nécessaire, tu peux ajouter des actions après la compilation et l'analyse
                    echo 'Post build actions'
                }
            }
        }
    }

    post {
        success {
            echo 'Build et analyse SonarQube réussis !'
        }
        failure {
            echo 'Une erreur s\'est produite pendant le build ou l\'analyse SonarQube.'
        }
    }
}
