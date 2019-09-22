#Dockerfile
# The FROM directive sets the base image for subsequent instructions
FROM java:8


ENV APP_NAME docker-learner

ADD target/docker-learner-0.0.1-SNAPSHOT.jar .

# java -jar crm-1.0-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "docker-learner-0.0.1-SNAPSHOT.jar"]

