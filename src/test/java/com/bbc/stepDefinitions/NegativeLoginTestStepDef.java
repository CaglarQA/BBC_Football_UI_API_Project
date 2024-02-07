package com.bbc.stepDefinitions;

import com.bbc.pages.LoginPage;
import com.bbc.utility.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class NegativeLoginTestStepDef {

    LoginPage loginPage = new LoginPage();

    @When("user clicks sign in link")
    public void user_clicks_sign_in_link() throws InterruptedException {
        while (true){
            try {
                loginPage = new LoginPage();
                loginPage.sigInButton.click();
                break;
            }catch (RuntimeException e){
                Driver.getDriver().navigate().refresh();
                System.out.println("page is refreshed because of pop-up");
            }
        }
    }

    @When("user types {string} into input box and {string}")
    public void user_types_into_input_box_and(String keyword, String action) throws InterruptedException {

       loginPage.inputBox.sendKeys(keyword);
       if(action=="enter") {
           Actions act = new Actions(Driver.getDriver());
           act.sendKeys(Keys.ENTER).perform();
       }
       else{
           loginPage.submitButton.click();
       }
    }

    @Then("user should see {string}")
    public void user_should_see(String expectErrorMsg) {
        String actualErrorMsg = loginPage.errorMsg.getText();
        Assert.assertEquals(expectErrorMsg,actualErrorMsg);
    }
}
