package com.bbc.pages;

import com.bbc.utility.Driver;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(className = "orbit-search__button")
    public WebElement searchBox;

    @FindBy(id = "idcta-username")
    public WebElement sigInButton;




}
