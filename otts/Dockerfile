FROM amazoncorretto:17
VOLUME /home/blog/otts
WORKDIR /home/blog/otts
COPY target/*.jar otts.jar
COPY src/main/resources/application.properties config/application.properties
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "otts.jar"]