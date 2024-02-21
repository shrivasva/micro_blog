FROM amazoncorretto:17
VOLUME /home/blog/notify
WORKDIR /home/blog/notify
COPY target/*.jar notify.jar
COPY src/main/resources/application.properties .
EXPOSE 8092
ENTRYPOINT ["java", "-jar", "notify.jar"]