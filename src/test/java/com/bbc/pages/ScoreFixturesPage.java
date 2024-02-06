package com.bbc.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ScoreFixturesPage extends BasePage {

    @FindBy(xpath = "//abbr/following-sibling::span")
    public List<WebElement> teams;

}
