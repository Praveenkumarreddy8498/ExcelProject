FROM openjdk:11
EXPOSE 8888 
COPY /target/config.jar config.jar
ENTRYPOINT [ "java","-jar","config.jar"]