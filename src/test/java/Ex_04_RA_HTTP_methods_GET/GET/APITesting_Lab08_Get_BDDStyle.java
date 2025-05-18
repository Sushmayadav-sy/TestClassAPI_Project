package Ex_04_RA_HTTP_methods_GET.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting_Lab08_Get_BDDStyle {
    @Test

    public void test_Get_positive() {
        String pin_code = "388620";
        RestAssured
                .given()
                .baseUri("https://api.zippotam.us")
                .basePath("/IN/" + pin_code)
                .when()
                .log()
                .all()
                .get()
                .then()
                .log().all()
                .statusCode(200);
    }
}
