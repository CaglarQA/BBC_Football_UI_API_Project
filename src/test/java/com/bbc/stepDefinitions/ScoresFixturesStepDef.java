package com.bbc.stepDefinitions;

import com.bbc.pages.ScoreFixturesPage;
import com.bbc.utility.ConfigurationReader;
import com.bbc.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class ScoresFixturesStepDef {
    ScoreFixturesPage scoreFixturesPage = new ScoreFixturesPage();

    @Given("user lands on {string} page")
    public void user_lands_on_page(String title) throws InterruptedException {
        String goToUrl= ConfigurationReader.getProperty(title);
        Driver.getDriver().get(goToUrl);
        Assert.assertTrue(Driver.getDriver().getTitle().contains(title));
    }


    @When("user sees all team names with a match today")
    public void user_sees_all_team_names_with_a_match_today() {
        if(scoreFixturesPage.teams.isEmpty())return;
        for (WebElement eachTeam : scoreFixturesPage.teams) {
            System.out.println( eachTeam.getText());
        }
        System.out.println("scoreFixturesPage.teams.size() = " + scoreFixturesPage.teams.size());
    }
    @When("if there is no matches today, display a message")
    public void if_there_is_no_matches_today_display_a_message() {
        if(scoreFixturesPage.teams.isEmpty()) System.out.println("There is no matches today!");
    }


}
