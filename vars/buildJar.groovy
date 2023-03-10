#!/usr/bin/env groovy

def call(){
    echo 'Build mvnApp application'
    echo "Build version ${NEW_VERSION}"
    sh'mvn package'
}