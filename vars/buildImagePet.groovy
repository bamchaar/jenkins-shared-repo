#!/usr/bin/env groovy

def call(){
    echo 'Building Docker image'       
    sh 'docker-compose up -d'
}
