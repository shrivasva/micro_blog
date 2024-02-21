FROM amazoncorretto:17
VOLUME /home/blog/blog
WORKDIR /home/blog/blog
COPY target/*.jar blog.jar
COPY src/main/resources/application.properties .
EXPOSE 8092
ENTRYPOINT ["java", "-jar", "blog.jar"]