package com.task.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='text']")
    public WebElement username_txt_field;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement password_txt_field;

    @FindBy(xpath = "(//div[@role='button'])[1]")
    public WebElement login_button;


    public void set_username(String username)
    {
        username_txt_field.sendKeys(username);
    }
    public void set_password(String password)
    {
        password_txt_field.sendKeys(password);
    }
     public void click_on_login_button()
    {
        login_button.click();
    }
    public void login(String username,String password)

    {
        username_txt_field.sendKeys(username);
        password_txt_field.sendKeys(password);
        login_button.click();
    }
    public String get_current_url()
    {
      return  driver.getCurrentUrl();
    }
}
