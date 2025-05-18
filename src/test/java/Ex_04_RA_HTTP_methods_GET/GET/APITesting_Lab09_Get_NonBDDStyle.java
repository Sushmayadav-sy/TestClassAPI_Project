package Ex_04_RA_HTTP_methods_GET.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_Lab09_Get_NonBDDStyle {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_Get_NonBDD()
    {
        String pincode = "560066";

        //Given
        r = RestAssured.given();
        r.baseUri("https://api.zippotam.us");
        r.basePath("/IN/" +pincode);
        //When
        response =r.when().log().all().get();

        System.out.println(response.asString());
        //Then
        vr = response.then().log().all();
        vr.statusCode(200);

    }
}
