FROM openjdk:8
ADD target/jenkinsdeploy.jar jenkinsdeploy.jar
EXPOSE 80
ENTRYPOINT ["java" , "-jar" , "/jenkinsdeploy.jar"]