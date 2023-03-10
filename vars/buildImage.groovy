#!/usr/bin/env groovy

def call(){
    echo 'Building Docker image'
    withCredentials([usernamePassword(credentialsId: 'tcdmvPipeLine',passwordVariable: 'PASS' , usernameVariable: 'USER')]) {
        sh 'docker build -t tcdmv/mvn-app:java-mvn-2.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push tcdmv/mvn-app:java-mvn-2.0'
    }
}