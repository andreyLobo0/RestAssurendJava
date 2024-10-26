package automated.api.testing.resources;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;


public class SetupTest {

    @BeforeAll
    public static void setup(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        baseURI = "https://petstore.swagger.io";
        basePath = "/v2";
    }
}
