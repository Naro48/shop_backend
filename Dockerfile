FROM openjdk:22-oracle
COPY target/*.jar shop_app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","shop_app.jar"]