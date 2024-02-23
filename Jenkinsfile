pipeline {
    agent any

    environment {
        // Define environment variables
        DOCKER_HUB_CREDENTIALS = 'dockerhub_credentials'
        DOCKER_IMAGE_NAME = "salmaghabri/cuddly-container"
        REPO_URL = "https://github.com/salmaghabri/cuddly-container"
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the repository
                git credentialsId: env.DOCKER_HUB_CREDENTIALS, url: env.REPO_URL
            }
        }

        stage('Build Docker Image') {
            steps {
                // Build Docker image
                script {
                    docker.build(env.DOCKER_IMAGE_NAME, "-f Dockerfile .")
                }
            }
        }

        stage('Push to DockerHub') {
            steps {
                // Push Docker image to DockerHub
                script {
                    docker.withRegistry('https://index.docker.io/v1/', env.DOCKER_HUB_CREDENTIALS) {
                        docker.image(env.DOCKER_IMAGE_NAME).push('latest')
                    }
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline successfully completed!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
