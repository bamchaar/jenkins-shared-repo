#!/usr/bin/env groovy

def call(){
    echo 'Building Docker image'
    withCredentials([usernamePassword(credentialsId: 'bamchaarJenkinsKey',passwordVariable: 'PASS' , usernameVariable: 'USER')]) {
        sh 'docker build -t bamchaar/my-app:java-mvn-2.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push bamchaar/my-app:java-mvn-2.0'
    }
}
