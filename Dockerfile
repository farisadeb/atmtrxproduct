FROM openjdk:8
ADD target/atmtrxproduct-0.0.1-SNAPSHOT.jar atmtrxproduct-0.0.1-SNAPSHOT.jar
EXPOSE 9084
ENTRYPOINT ["java", "-jar", "atmtrxproduct-0.0.1-SNAPSHOT.jar"]