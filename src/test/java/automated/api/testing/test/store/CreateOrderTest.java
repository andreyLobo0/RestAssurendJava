package automated.api.testing.test.store;

import automated.api.testing.data.StoreOrderData;
import automated.api.testing.resources.SetupTest;
import jdk.jfr.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;

public class CreateOrderTest extends SetupTest {
    private static final String CREATE_ORDER = "/store/order";

    @Test
    @Description("Create Order - Success - Must create a pet order successfully")
    public void createOrderSuccess() {
        // Arrange
        StoreOrderData order = new StoreOrderData(1000, 11, 1, "2024-10-25T18:26:26.539Z", "pending", true);
        // Act
        given().
                body(order).
                when().
                post(CREATE_ORDER).
                then().
                // Assert
                statusCode(HttpStatus.SC_OK).
                body(notNullValue()).
                body("id", is(1000)).
                body("petId", is(11)).
                body("quantity", is(1)).
                body("shipDate", is("2024-10-25T18:26:26.539+0000")).
                body("status", is("pending")).
                body("complete", is(true));
    }
}
