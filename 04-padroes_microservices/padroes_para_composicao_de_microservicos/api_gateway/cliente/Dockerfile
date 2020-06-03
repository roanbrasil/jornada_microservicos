 #FROM open-jdk:8-jre-alpine
 FROM openjdk:8-jdk-alpine
 COPY ./target/dependencies /app/dependencies
 #COPY ./target/resources /app/resources
 COPY ./target/classes /app/classes
 ENTRYPOINT java -cp /app/dependencies/*:/app/resources/:/app/classes br.com.jornada.cliente.ClienteApplication

#FROM openjdk:8-jdk-alpine
#RUN addgroup -S spring && adduser -S spring -G spring
#USER spring:spring
#ARG DEPENDENCY=target/dependency
#COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY ${DEPENDENCY}/META-INF /app/META-INF
#COPY ${DEPENDENCY}/BOOT-INF/classes /app
#ENTRYPOINT ["java","-cp","app:app/lib/*","hello.Application"]

#FROM openjdk:8-jdk-alpine
#ARG JAR_FILE=./target/*.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]
#

