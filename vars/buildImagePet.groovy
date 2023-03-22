#!/usr/bin/env groovy

def call(){
    echo 'Building Docker image' 
    withCredentials([usernamePassword(credentialsId: 'bamchpat',passwordVariable: 'PASS' , usernameVariable: 'USER')]) {
        sh "echo $PASS | docker login -u $USER --password-stdin"
        git branch: 'main', url: 'https://github.com/bamchaar/petclinic-microservices-with-db.git'
        sh 'docker-compose up -d'
    }

}
