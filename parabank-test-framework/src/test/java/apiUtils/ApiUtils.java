package apiUtils;

import io.restassured.RestAssured;

public class ApiUtils {

    // Login and get session ID using REST Assured
    public static void loginAndGetSessionId() {
        // Ensure REST Assured config is initialized
        RestAssured.config = RestAssuredSetup.getRestAssuredConfig();

        // Your login API request logic here, for example:
        RestAssured.given()
            .baseUri("https://example.com")
            .formParam("username", "testuser")
            .formParam("password", "password123")
            .post("/login")
            .then()
            .statusCode(200); // Ensure successful login
    }
}
