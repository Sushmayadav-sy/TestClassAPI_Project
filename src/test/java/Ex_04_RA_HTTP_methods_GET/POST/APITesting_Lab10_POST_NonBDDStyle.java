package Ex_04_RA_HTTP_methods_GET.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_Lab10_POST_NonBDDStyle {
    RequestSpecification r;
    Response res;
    ValidatableResponse vr;
    //RestAssured.given()
    //                .baseUri("https://restful-booker.herokuapp.com")
    //                .basePath("/auth")
    //                .contentType(ContentType.JSON)
    //                .log().all().body(payload)
    //                .when()
    //                .log().all()
    //                .post()
    //                .then().log().all()
    //                .statusCode(200);
    @Test

    public void test_Post_Auth(){

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        System.out.println("--------part 1-------");

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON);
        r.log().all().body(payload);


        System.out.println("-------part 2-------");

        res = r.when().log().all().post();


        System.out.println("------part 3------");

        vr = res.then().log().all();
        vr.statusCode(200);


    }
}
