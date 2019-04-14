FROM openjdk:11-jre-slim
VOLUME /tmp

ENV JAVA_OPTS="-Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8787,suspend=n"
EXPOSE 8080 8787

RUN mkdir -p /opt
COPY ./target/backend-0.0.1-SNAPSHOT.jar /opt
RUN sh -c 'touch backend-0.0.1-SNAPSHOT.jar'  
ENTRYPOINT ["java", "-Dspring.data.mongodb.uri=mongodb://mongodb/music","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=dev","-jar","/opt/backend-0.0.1-SNAPSHOT.jar"]  
