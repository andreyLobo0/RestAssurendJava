package automated.api.testing.test.store;

import automated.api.testing.data.StoreOrderData;
import automated.api.testing.resources.SetupTest;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CreateOrderTest extends SetupTest {
    private static final String CREATE_ORDER = "/store/order";

    @Test
    public void createOrderSuccess() {
        StoreOrderData order = new StoreOrderData(1000, 11, 1, "2024-10-25T18:26:26.539Z", "placed", true);
        given().
                contentType("application/json").
                body(order).
                when().
                post(CREATE_ORDER).
                then().
                statusCode(HttpStatus.SC_OK);
    }
}
