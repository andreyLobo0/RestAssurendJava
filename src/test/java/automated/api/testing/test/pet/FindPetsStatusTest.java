package automated.api.testing.test.pet;

import automated.api.testing.resources.SetupTest;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;

public class FindPetsStatusTest extends SetupTest {

    private static final String FIND_PET_STATUS = "pet/findByStatus";

    @Test
    @Description("Find Pets Status - Pending - Seccess - Must return all pet records with pending status")
    public void findPetsStatusPendingWithSuccess() {
        // Arrange
        // Act
        Response response = given().
                param("status", "pending").
        when().
                get(FIND_PET_STATUS).
        then().
                // Assert
                statusCode(HttpStatus.SC_OK).
                extract().response();
        List<String> statusList = response.jsonPath().getList("status");
        assertThat(statusList, everyItem(equalTo("pending")));
    }
}
