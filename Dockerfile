FROM openjdk:11

ENV JAVA_OPTS="-Xms50m -Xmx256m"
COPY target/person-app.jar /person-app.jar
ENTRYPOINT java ${JAVA_OPTS} -jar /person-app.jar