FROM openjdk:21-slim
WORKDIR /app
COPY target/admin-service-1.0.0.jar /app/admin-service.jar
ENV SPRING_PROFILES_ACTIVE=prod
CMD ["java", "-jar", "admin-service.jar"]

# mvn package
# create jar file
# docker build -t gray/
# docker images