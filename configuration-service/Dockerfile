FROM openjdk:13
COPY ./build/libs/configuration-service-0.0.2.jar /usr/app/
WORKDIR /usr/app/
EXPOSE 8888:8888
ENTRYPOINT ["java", "-jar", "configuration-service-0.0.2.jar"]