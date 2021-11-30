# zooplusAPIRepo
Small POC for API

## Techs Used
Java, Cucumber, Rest Assured, Extent

## Pre-Requisite
- Java 8 and above
- Any IDE
- Install Maven and set the Environment Variable
- For Cucumber's actual flavour, install a plugin for cucumber in IDE and convert project into cucumber project
- Download and Extract this project to your local or use git clone https://github.com/aravind12c/flinktestassesment.git
- Import as a Maven project in any IDE

## Setup Petstore Environment
- Use git clone https://github.com/swagger-api/swagger-petstore.git or download the project and extract it
- If you have docker, then start the docker engine and use below commands
```
cd <project location>
docker build -t swaggerapi/petstore3:unstable .
docker pull swaggerapi/petstore3:unstable
docker run  --name swaggerapi-petstore3 -d -p 8080:8080 swaggerapi/petstore3:unstable
```
- If you don't have docker, then import the project in any ide and wait for all the Jars to be downloaded then use below command or in run configuartion
```
mvn package jetty:run
```
    
## Steps 
- In command prompt use mvn clean install or in Run configuarions run as Maven clean install.

The test cases are designed in such a way that, for every action like Post/Put/Delete, I am trying to get the specific ID to validate whether the changes are updated or not.
