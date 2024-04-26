# Docker 镜像构建
# @author y138g
# @from <a href="https://github.com/y138g">yg的开源仓库</a>
FROM maven:3.8.1-jdk-11-slim as builder

# Copy local code to the co  ntainer image.
WORKDIR /app
COPY pom.xml .
COPY src ./src

# Build a release artifact.
RUN mvn package -DskipTests

# Run the web service on container startup.
CMD ["java","-jar","/app/target/zhaoj_backend-0.0.1-SNAPSHOT.jar","--spring.profiles.active=prod"]