FROM openjdk:21-slim
WORKDIR /app
COPY target/order-service-1.0.0.jar /app/order-service.jar
ENV SPRING_PROFILES_ACTIVE=prod
CMD ["java", "-jar", "order-service.jar"]

# mvn package
# create jar file
# docker build -t gray/
# docker images