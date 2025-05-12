package Ex_01_Basics;

import io.restassured.RestAssured;

import java.util.Scanner;

public class Lab02_RA {

    public static void main(String[] args) {


        //Gherlins Syntax
        //Given() --> Pre Re - URL, Headers, Auth, Body..
        //When () --> HTTP methods? - Get, post, put, delete, pach..
        //Then() --> validation -> 200 ok, firstname == Sushma

        // Full URL -> https://restful-booker.herokuapp.com/booking
        // Base URI - https://restful-booker.herokuapp.com
        // base path - /booking


        Scanner sc = new Scanner(System.in);
        String pincode = sc.next();

        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/" + pincode)
                .when()
                    .get()
                .then().log().all()
                    .statusCode(200);
    }
}
