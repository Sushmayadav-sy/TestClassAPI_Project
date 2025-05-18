package Ex_04_RA_HTTP_methods_GET.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.Scanner;

public class APITesting_Lab01_DeleteReq {

    @Test

    public void test_Delete_booking() {
        RequestSpecification r;
        Response res;
        ValidatableResponse vr;

        Scanner sc = new Scanner(System.in);

//        String booking_id = sc.next();
//        System.out.println(booking_id);
//        String token = sc.next();
//        System.out.println(token);
        String booking_id = "585";
        String token = "20ffdbc8e4da7f1";


        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+booking_id);
        r.contentType(ContentType.JSON);
        r.cookie("token", token);
        r.log().all();


        System.out.println("-------part 2-------");

        res = r.when().log().all().delete();


        System.out.println("------part 3------");

        vr = res.then().log().all();
        vr.statusCode(200);

    }
}
