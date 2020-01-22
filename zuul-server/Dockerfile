FROM openjdk:13
COPY ./build/libs/zuul-service-0.0.1.jar /usr/app/
WORKDIR /usr/app/
EXPOSE 8765:8765
ENTRYPOINT ["java", "-jar", "zuul-service-0.0.1.jar"]