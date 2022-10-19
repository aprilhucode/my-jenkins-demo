pipeline {
    agent any
    tools {
        maven 'maven_v3.8.5'
        jdk 'jdk1.8'
    }
    stages {
        stage('Build Maven') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/aprilhucode/my-jenkins-demo']]])
                bat "mvn clean install"
            }
        }
        stage('Build Docker image') {
            steps {
                script {
                    bat 'docker build -t aprilhucode/jenkins-demo .'
                }
            }
        }
        stage('Push image to Docker Hub') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'dockerhub-password', variable: 'DOCKERHUB_PASSWORD')]) {
                        bat "docker login -u aprilhucode -p ${DOCKERHUB_PASSWORD}"
                    }
                    bat 'docker push aprilhucode/jenkins-demo'
                }
            }
        }
    }
}