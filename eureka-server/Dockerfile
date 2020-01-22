FROM openjdk:13
COPY ./build/libs/eureka-server-0.0.1.jar /usr/app/
WORKDIR /usr/app/
EXPOSE 8761:8761
ENTRYPOINT ["java", "-jar", "eureka-server-0.0.1.jar"]