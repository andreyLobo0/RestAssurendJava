package automated.api.testing.test.pet;

import automated.api.testing.resources.SetupTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;

public class FindPetsStatusTest extends SetupTest {

    private static final String FIND_PET_STATUS = "pet/findByStatus";

    @Test
    public void findPetsStatusPending() {
        given().
                param("status", "pending").
        when().
                get(FIND_PET_STATUS).
        then().
                statusCode(200).
                body("data", is(notNullValue()));
    }
}
