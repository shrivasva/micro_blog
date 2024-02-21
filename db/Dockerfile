FROM amazoncorretto:17
VOLUME /home/blog/db
WORKDIR /home/blog/db
COPY target/*.jar db.jar
COPY src/main/resources/application.properties application.properties
EXPOSE 8091
ENTRYPOINT ["java", "-jar", "db.jar"]