FROM eclipse-temurin:17
LABEL maintainer="contatoteste@java10x.dev"
WORKDIR /app
COPY target/DockerAulaJava10x-0.0.1-SNAPSHOT.jar /app/implementandoDockerEstudos.jar
ENTRYPOINT ["java", "-jar", "implementandoDockerEstudos.jar" ]

