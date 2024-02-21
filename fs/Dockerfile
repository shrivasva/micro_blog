FROM amazoncorretto:17
VOLUME /home/blog/fs
WORKDIR /home/blog/fs
COPY target/*.jar fs.jar
COPY src/main/resources/application.properties .
EXPOSE 8092
ENTRYPOINT ["java", "-jar", "fs.jar"]