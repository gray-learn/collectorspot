FROM openjdk:21-slim
WORKDIR /app
COPY target/image-service-1.0.0.jar /app/image-service.jar
ENV SPRING_PROFILES_ACTIVE=prod
CMD ["java", "-jar", "image-service.jar"]

# mvn package
# create jar file
# docker build -t gray/
# docker images