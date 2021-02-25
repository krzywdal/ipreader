# ipreader
Simple web service returning public ip and user-agent

## Building the jar
 ./gradlew bootJar
 
## Starting the server
java -jar ipreader-0.0.1-SNAPSHOT.jar

or with port specified

java -Dserver.port=8080 -jar ipreader-0.0.1-SNAPSHOT.jar

## Usage
Server exposes /ipinfo endpoint

For port 8080 it will be http://127.0.0.1:8080/ipinfo

