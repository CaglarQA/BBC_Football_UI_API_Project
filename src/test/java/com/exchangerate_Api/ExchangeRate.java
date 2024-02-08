package com.exchangerate_Api;

import org.junit.Before;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class ExchangeRate {
    String url = "https://v6.exchangerate-api.com/v6/1fc80820c72b0163bc9c7536/latest/USD";

    Response response;

    @Before
    public void testSetup() {
        response = given()
                .accept(ContentType.JSON)
                .when()
                .get(url)
                .then()
                .extract().response();
    }

    @Test
    public void test1() {
        response
                .then()
                .statusCode(200);

    }

    @Test
    public void test2() {
        int numberOfCurrency = response.path("conversion_rates.size()");
        System.out.println("numberOfCurrency = " + numberOfCurrency);

    }

    @Test
    public void test3(){
        response.prettyPeek()
                .then()
                .body("conversion_rates", hasKey( "AMD"));
    }

}


