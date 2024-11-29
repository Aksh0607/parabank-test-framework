package apiUtils;

import io.restassured.config.SSLConfig;
import io.restassured.config.RestAssuredConfig;

public class RestAssuredSetup {

    // Return a configured RestAssuredConfig with SSL relaxation
    public static RestAssuredConfig getRestAssuredConfig() {
        return RestAssuredConfig.config()
                .sslConfig(new SSLConfig().allowAllHostnames());  // Relax SSL validation
    }
}
