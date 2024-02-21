FROM amazoncorretto:17
VOLUME /home/blog/user
WORKDIR /home/blog/user
COPY target/*.jar user.jar
COPY src/main/resources/application.properties application.properties
EXPOSE 8092
ENTRYPOINT ["java", "-jar", "user.jar"]