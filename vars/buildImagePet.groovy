#!/usr/bin/env groovy

def call(){
    echo 'Building Docker image' 
    git branch: 'main', url: 'https://github.com/bamchaar/petclinic-microservices-with-db.git'
    sh 'docker-compose up -d'
}
