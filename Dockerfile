FROM openjdk:11

COPY AlfaGiphy-0.0.1-SNAPSHOT.jar /alfa-giphy-app.jar

CMD [ "java", "-jar", "/alfa-giphy-app.jar" ]