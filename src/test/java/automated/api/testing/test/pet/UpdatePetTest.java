package automated.api.testing.test.pet;

import automated.api.testing.data.PetCategoryData;
import automated.api.testing.data.PetData;
import automated.api.testing.data.PetTagsData;
import automated.api.testing.resources.SetupTest;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static io.restassured.RestAssured.given;

public class UpdatePetTest extends SetupTest {
    private static final String CREATE_ORDER = "/pet";

    public PetData createTestPet() {
        return PetData.builder()
                .id(10L)
                .category(PetCategoryData.builder()
                        .id(1010L)
                        .name("update pet")
                        .build())
                .name(" Bull Dog")
                .photoUrls(Collections.singletonList("http://www.photo1.1.com"))
                .tags(Collections.singletonList(
                        PetTagsData.builder()
                                .id(12345L)
                                .name("French Bull Dog")
                                .build()))
                .status("available")
                .build();
    }

    @Test
    public void updatePetSuccess() {
        PetData pet = createTestPet();
        given().
                contentType("application/json").
                body(pet).
                when().
                post(CREATE_ORDER).
                then().
                statusCode(HttpStatus.SC_OK);
    }
}
