package com.task.tests;

import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;
import com.task.pages.HomePage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class HomeTest  extends TestBase{

    public HomeTest() throws IOException {
    }
    HomePage homeobject;
    String text = RandomStringUtils.randomAlphabetic(3);

    @Test(priority = 1)
    public void send_tweet_with_length_less_than_280_characters()
    {

        String tweet_text= RandomStringUtils.randomAlphabetic(279);
        homeobject=new HomePage(driver);
        homeobject.click_on_home();
        homeobject.write_tweet(tweet_text);
        Assert.assertTrue(homeobject.message.isDisplayed());

    }
      @Test(priority = 2)
    public void send_tweet_with_length_equal_to_280_characters()
    {
        String tweet_text=RandomStringUtils.randomAlphabetic(280);
        homeobject.text_area_tweet.clear();
        homeobject.write_tweet(tweet_text);
        Assert.assertTrue(homeobject.message.isDisplayed());
    }
    @Test(priority = 3)
    public void send_tweet_with_length_more_than_280_characters()  {
        String tweet_text=RandomStringUtils.randomAlphabetic(281);
        homeobject.write_tweet(tweet_text);
        SoftAssert softAssert=new SoftAssert();
        System.out.println(homeobject.tweet_button.isSelected());
        softAssert.assertFalse(homeobject.tweet_button.isSelected());
        homeobject.close_tweet.click();
        homeobject.discard_button.click();
        softAssert.assertAll();
    }
    @Test(priority = 4)
    public void send_tweet_with_text() {
        
        homeobject.tweet_link.click();
        homeobject.text_area_tweet.sendKeys(text);
        homeobject.tweet_button.click();
        Assert.assertTrue(homeobject.message.isDisplayed());
    }
    @Test(priority = 5)
    public void send_tweet_with_same_text_already_sent()
    {
        homeobject.tweet_link.click();
        homeobject.text_area_tweet.sendKeys(text);
        homeobject.tweet_button.click();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(homeobject.alert_same_tweet.isDisplayed());
        homeobject.close_tweet.click();
        homeobject.discard_button.click();
        softAssert.assertAll();
    }
    @Test(priority = 6)
    public void send_tweet_with_poll() throws InterruptedException {
        String question= RandomStringUtils.randomAlphabetic(5);
        String  choice1=RandomStringUtils.randomAlphabetic(3);
        String choice2=RandomStringUtils.randomAlphabetic(3);
        homeobject.send_tweet_include_poll(question,choice1,choice2);
        Assert.assertTrue(homeobject.message.isDisplayed());

    }
    @Test(priority = 7)
    public void send_tweet_with_gif() throws InterruptedException {
        homeobject.send_tweet_include_gif();
        homeobject.tweet_button.click();
        Assert.assertTrue(homeobject.message.isDisplayed());
    }

    @Test(priority = 8)
    public void can_not_include_gif_and_image_in_one_tweet() throws InterruptedException {

      homeobject.send_tweet_include_gif();
    System.out.println(homeobject.gallery_button.getText());
     SoftAssert softAssert=new SoftAssert();
      softAssert.assertFalse(homeobject.gallery_button.isSelected());
      homeobject.tweet_button.click();
      softAssert.assertAll();
    }
    @Test(priority = 9)
    public void can_not_include_gif_and_poll_in_one_tweet() throws InterruptedException {
        homeobject.send_tweet_include_gif();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertFalse(homeobject.poll_button.isSelected());
        homeobject.tweet_button.click();
        softAssert.assertAll();
    }
}
