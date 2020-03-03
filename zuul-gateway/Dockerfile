FROM openjdk:13
COPY ./build/libs/zuul-gateway-0.0.1.jar /usr/app/
WORKDIR /usr/app/
EXPOSE 9000:9000
ENTRYPOINT ["java", "-jar", "zuul-gateway-0.0.1.jar"]