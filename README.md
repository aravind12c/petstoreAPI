# zooplusAPIRepo
Small POC for API

## Techs Used
Java, Cucumber, Rest Assured, Extent

## Steps
- Download and Extract this project to your local 
- Import as a Maven project in IDE
- Open TestRunner.java file, from "\src\test\java\apiRunner"
- Now run as JUnit Test (Make sure to run in JUnit 4)

The test cases are designed in such a way that, for every action like Post/Put/Delete, I am trying to get the specific ID to validate whether the changes are updated or not. The API provided to me is taking time to update/to synchronize due to which there are chances of few test cases may fail.
Note: This can be handled by adding wait time for each case solution provided below.

**Solution:**
Below are the ways to handle the above situations:
- Use ResponseSpecBuilder class to simulate the request/response time.
- Use Sleep to manage static wait.
- Set a condition to validate the response and wait till we receive a response by polling for some period of time.
