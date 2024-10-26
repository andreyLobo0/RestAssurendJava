package automated.api.testing.test.pet;

import automated.api.testing.data.PetCategoryData;
import automated.api.testing.data.PetData;
import automated.api.testing.data.PetTagsData;
import automated.api.testing.resources.SetupTest;
import jdk.jfr.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;

public class UpdatePetTest extends SetupTest {
    private static final String CREATE_ORDER = "/pet";

    public PetData createTestPet() {
        return PetData.builder()
                .id(10L)
                .category(PetCategoryData.builder()
                        .id(1010L)
                        .name("update pet")
                        .build())
                .name("Bull Dog")
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
    @Description("Update Pet - Success - You must update the registration data of an existing pet")
    public void updatePetSuccess() {
        // Arrange
        PetData pet = createTestPet();
        // Act
        given().
                body(pet).
                when().
                post(CREATE_ORDER).
                then().
                // Assert
                statusCode(HttpStatus.SC_OK).
                body(notNullValue()).
                body("id", is(10)).
                body("category.id", is(1010)).
                body("category.name", is("update pet")).
                body("name", is("Bull Dog")).
                body("photoUrls[0]", is("http://www.photo1.1.com")).
                body("tags[0].id", is(12345)).
                body("tags[0].name", is("French Bull Dog")).
                body("status", is("available"));
    }
}
