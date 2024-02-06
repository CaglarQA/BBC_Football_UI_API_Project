package com.bbc.pages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(id = "searchInput")
    public WebElement searchInput;


    @FindBy(xpath = "//a//p")
    public List<WebElement> headers;
}
