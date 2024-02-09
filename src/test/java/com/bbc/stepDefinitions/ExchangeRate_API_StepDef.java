package com.bbc.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class ExchangeRate_API_StepDef {

    Response response;
    int actualNumberOfCurrency =0;

    @Given("Get the Response by making an API query")
    public void get_the_response_by_making_an_apı_query() {
        System.out.println("-------------ExchaneRate--------------");
        String url = "https://v6.exchangerate-api.com/v6/1fc80820c72b0163bc9c7536/latest/USD";
        response = given()
                .accept(ContentType.JSON)
                .when()
                .get(url)
                .then()
                .extract().response();


    }
    @Then("Verify status code {int}")
    public void verify_status_code(Integer int1) {
        response
                .then()
                .statusCode(200);
    }
    @When("Calculate the Currency in Response")
    public void calculate_the_currency_in_response() {
         actualNumberOfCurrency = response.path("conversion_rates.size()");
        System.out.println("numberOfCurrency = " + actualNumberOfCurrency);
    }
    @Then("Verify that there are a total {int} currencies")
    public void verify_that_there_are_a_total_currencies(int expectedNumberOfCurrencies) {

        Assert.assertEquals(expectedNumberOfCurrencies,actualNumberOfCurrency);


    }
    @When("Print response")
    public void print_response() {
      response.prettyPeek();
    }
    @Then("Verify the currency {string} is shown within the response")
    public void verify_the_currency_is_shown_within_the_response(String expectedCurrency) {
        response
                .then()
                .body("conversion_rates", hasKey( expectedCurrency));

    }


}
