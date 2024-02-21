FROM amazoncorretto:17
VOLUME /home/blog/gateway
WORKDIR /home/blog/gateway
COPY target/*.jar gateway.jar
COPY src/main/resources/application.yaml application.yaml
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "gateway.jar"]