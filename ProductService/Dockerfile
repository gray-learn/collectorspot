FROM openjdk:21-slim
WORKDIR /app
COPY target/product-service-1.0.0.jar /app/product-service.jar
ENV SPRING_PROFILES_ACTIVE=prod
CMD ["java", "-jar", "product-service.jar"]

# mvn package
# create jar file
# docker build -t gray/
# docker images