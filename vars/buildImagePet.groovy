#!/usr/bin/env groovy

def call(){
    echo 'Building Docker image'
                dir('/blob/main/docker-compose.yml') {
                    sh 'docker-compose up -d'
    }
}
