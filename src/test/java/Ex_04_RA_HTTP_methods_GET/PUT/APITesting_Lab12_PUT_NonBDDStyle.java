package Ex_04_RA_HTTP_methods_GET.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_Lab12_PUT_NonBDDStyle {


    //        curl -X PUT \
//        https://restful-booker.herokuapp.com/booking/1 ===> Here I need ID
//        -H 'Content-Type: application/json' \
//        -H 'Accept: application/json' \
//        -H 'Cookie: token=abc123' ===> here i need token also
//        -d '{
//        "firstname" : "James",
//            "lastname" : "Brown",
//            "totalprice" : 111,
//            "depositpaid" : true,
//            "bookingdates" : {
//        "checkin" : "2018-01-01",
//                "checkout" : "2019-01-01"
//    },
//        "additionalneeds" : "Breakfast"
//    }'


    @Test

    public void test_update_booking_nonBDD()
    {
        RequestSpecification r;
        Response res;
        ValidatableResponse vr;

         String payload = "{\n" +
                 "    \"firstname\" : \"Sushma\",\n" +
                 "    \"lastname\" : \"Yadav\",\n" +
                 "    \"totalprice\" : 111,\n" +
                 "    \"depositpaid\" : true,\n" +
                 "    \"bookingdates\" : {\n" +
                 "        \"checkin\" : \"2018-01-01\",\n" +
                 "        \"checkout\" : \"2019-01-01\"\n" +
                 "    },\n" +
                 "    \"additionalneeds\" : \"Breakfast\"\n" +
                 "}";

         String token = "ce3679d04487956";

         String booking_id = "1835";

        System.out.println("--------part 1-------");

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+booking_id);
        r.contentType(ContentType.JSON);
//        r.auth().auth, auth 2 etc can be used
        r.cookie("token", token);
        r.body(payload).log().all();


        System.out.println("-------part 2-------");

        res = r.when().log().all().put();


        System.out.println("------part 3------");

        vr = res.then().log().all();
        vr.statusCode(200      );

    }
}
