package Ex_04_RA_HTTP_methods_GET.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class APITesting_Lab11_POST_BDDStyle {

    @Test

    public void test_post_Auth()
    {

        // URl - https://restful-booker.herokuapp.com/auth
        //{
        //    "username" : "admin",
        //    "password" : "password123"
        //}
 String payload = "{\n" +
         "    \"username\" : \"admin\",\n" +
         "    \"password\" : \"password123\"\n" +
         "}";
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType(ContentType.JSON)
                .log().all().body(payload)
                .when()
                .log().all()
                .post()
                .then().log().all()
                .statusCode(200);

    }
}
