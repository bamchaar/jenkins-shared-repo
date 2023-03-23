#!/usr/bin/env groovy

def call(){
    echo 'Building Docker image' 
    withCredentials([usernamePassword(credentialsId: 'bamchpat',passwordVariable: 'PASS' , usernameVariable: 'USER')]) {
        git branch: 'main', url: 'https://github.com/bamchaar/petclinic-microservices-with-db.git'
        sh 'curl -sL https://deb.nodesource.com/setup_16.x | sudo -E bash -'
        sh 'sudo apt-get install -y nodejs'
        sh 'npm run build'
    }

}
