package com.task.tests;

import Data.JsonDataReader;
import com.task.pages.LoginPage;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends TestBase{
    public LoginTest() throws IOException {
    }
     LoginPage loginobject;
    @Test(priority = 0)
    public void login_with_valid_credentials() throws IOException, ParseException {
       loginobject=new LoginPage(driver);
        JsonDataReader jsonreader = new JsonDataReader();
        jsonreader.JsonReader();
       loginobject.login(jsonreader.username,jsonreader.password);
       // Assert.assertEquals(loginobject.get_current_url(),"https://twitter.com/home");
    }

}
