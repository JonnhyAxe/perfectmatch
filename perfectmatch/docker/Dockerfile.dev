FROM openjdk:11-jre-slim
EXPOSE 8080 
RUN mkdir -p /opt
COPY backend.jar /opt
RUN sh -c 'touch backend.jar'  
ENTRYPOINT ["java", "-Dspring.data.mongodb.uri=mongodb://mongodb/music","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=dev","-jar","/opt/backend.jar"]  
