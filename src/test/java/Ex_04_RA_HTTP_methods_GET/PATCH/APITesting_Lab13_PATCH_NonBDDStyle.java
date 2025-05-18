package Ex_04_RA_HTTP_methods_GET.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_Lab13_PATCH_NonBDDStyle {

    //curl -X PATCH \
    //  https://restful-booker.herokuapp.com/booking/1 \
    //  -H 'Content-Type: application/json' \
    //  -H 'Accept: application/json' \
    //  -H 'Cookie: token=abc123' \
    //  -d '{
    //    "firstname" : "James",
    //    "lastname" : "Brown"
    //}'


    @Test

    public void test_Patch_update_NonBDD(){

        RequestSpecification r;
        Response res;
        ValidatableResponse vr;

        String payload = "{\n" +
                "    \"firstname\" : \"Patric\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}";
        String token = "1cdca1c0ba9c800";
        String booking_id = "1457";

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+booking_id);
        r.cookie("token",token);
        r.contentType(ContentType.JSON);
        r.log().all().body(payload);

        res = r.log().all().patch();

        vr = res.then().log().all();
        vr.statusCode(200);

        System.out.println("updated");


    }
}
