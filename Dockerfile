
FROM amazoncorretto:17

MAINTAINER 4nd30rtega

COPY target/backend-0.0.1-SNAPSHOT.jar backend-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/backend-0.0.1-SNAPSHOT.jar"]

