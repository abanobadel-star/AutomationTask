package com.task.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
    public WebDriver driver;
    public Actions Action;

    public PageBase(WebDriver driver)  //constructor
    {
        PageFactory.initElements(driver, this);
    }

    public  void clickonbutton(WebElement button) //method to click on element
    {

        JavascriptExecutor js=((JavascriptExecutor)driver);
      //  js.executeScript("arguments[0].click();",button);

        js.executeScript("arguments[0].scrollIntoView(true);",button);

    }
    public  void setTextElementText(WebElement textElement, String value) //method to send text to element
    {
        textElement.sendKeys(value);
    }
}
