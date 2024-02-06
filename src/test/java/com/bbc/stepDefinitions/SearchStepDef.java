package com.bbc.stepDefinitions;

import com.bbc.pages.SearchPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class SearchStepDef {

    SearchPage searchPage = new SearchPage();

    @When("user clicks search box")
    public void user_clicks_search_box() {
        searchPage.searchBox.click();
    }
    @When("user types {string} into search box and hits the enter")
    public void user_types_into_search_box_and_hits_the_enter(String searchText) {
       searchPage.searchInput.sendKeys(searchText, Keys.ENTER);
    }
    @Then("list first heading and the last heading on the page")
    public void list_first_heading_and_the_last_heading_on_the_page() {

        System.out.println("First Header"+searchPage.headers.get(0).getText());
        System.out.println("Last Headers"+searchPage.headers.get(searchPage.headers.size()-1).getText().split("Listen Now")[1].trim());
    }
}
