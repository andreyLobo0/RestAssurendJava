package automated.api.testing.test.pet;

import automated.api.testing.resources.SetupTest;
import jdk.jfr.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;

public class FindPetTest extends SetupTest {
    private static final String FIND_PET = "/pet/10";

    @Test
    @Description("Find Pets - ID - Seccess - Must return the pet record corresponding to the sent ID")
    public void findPetsSuccess() {
        // Arrange
        // Act
        when().
                get(FIND_PET).
                // Assert
                then().
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
