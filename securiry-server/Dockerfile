FROM openjdk:13
COPY ./build/libs/auth-server-0.0.1.jar /usr/app/
WORKDIR /usr/app/
EXPOSE 9010:9010
ENTRYPOINT ["java", "-jar", "auth-server-0.0.1.jar"]