#!/usr/bin/env groovy

def call(){
    echo 'Building Docker image'
    withCredentials([usernamePassword(credentialsId: 'bamchaarJenkinsKey',passwordVariable: 'PASS' , usernameVariable: 'USER')]) {
        sh 'docker build -t bamchaar/my-app:java-mvn-2.0 .'
    withCredentials([usernamePassword(credentialsId: 'tcdmvkey',passwordVariable: 'PASS' , usernameVariable: 'USER')]) {
        sh 'docker build -t btcdmv/my-app:java-mvn-2.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
                dir('/blob/main/docker-compose.yml') {
                    sh 'docker-compose up -d'
                }
    }
}
