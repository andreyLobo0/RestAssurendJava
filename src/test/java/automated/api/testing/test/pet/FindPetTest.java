package automated.api.testing.test.pet;

import automated.api.testing.resources.SetupTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;

public class FindPetTest extends SetupTest {
    private static final String FIND_PET = "/pet/101";

    @Test
    public void findPetsStatusPending() {
        when().
                get(FIND_PET).
                then().
                statusCode(200);
    }
}
