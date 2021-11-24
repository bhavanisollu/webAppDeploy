pipeline{
    agent any
    tools {
        maven 'MyMaven'
    }
    stages {
        stage('Build Maven') {
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/bhavanisollu/webAppDeploy.git']]])
            
                bat "mvn -Dmaven.test.failure.ignore=true clean package"    
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                  bat 'docker build -t bhavani005/springboot-welcome .'
                }
            }
        }
        stage('Deploy Docker Image') {
            steps {
                script {
                 withCredentials([string(credentialsId: 'bhavani005', variable: 'dokerhubcred')]) {
                    bat "docker login -u bhavani005 -p ${dokerhubcred}"
                 }  
                 bat 'docker push bhavani005/springboot-welcome'
                }
            }
        }
        stage('Deploy to kubernetes'){
            steps{
                script{
                     // kubernetesDeploy(configs:"deploymentAndService.yaml" , kubeconfigId : "jenkins-deploy-kubernetes-id")
                    
                    try{
                    bat 'kubectl apply -f deployment.yaml --validate=false'
                    }
                    catch(error){
                    bat 'kubectl create -f deployment.yaml --validate=false'
                    }  
                }
            }
        }
    }
}
