package com.task.tests;

import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;
import com.task.pages.HomePage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        //   homeobject.click_on_home();
        homeobject.text_area_tweet.clear();
        homeobject.write_tweet(tweet_text);
        Assert.assertTrue(homeobject.message.isDisplayed());
    }
   // @Test(priority = 3)
    public void send_tweet_with_length_more_than_280_characters() throws InterruptedException {
        String tweet_text=RandomStringUtils.randomAlphabetic(281);
        // homeobject.click_on_home();
       homeobject.text_area_tweet.sendKeys(tweet_text);
       Thread.sleep(1000);
        Assert.assertFalse(homeobject.tweet_btn.isEnabled());
        homeobject.click_on_home();

    }
    @Test(priority = 4)
    public void can_not_send_same_tweet() {
        
        homeobject.tweet_link.click();
        homeobject.text_area_tweet.sendKeys(text);
        homeobject.tweet_button.click();
        Assert.assertTrue(homeobject.message.isDisplayed());
    }
    @Test(priority = 5)
    public void same_tweet()
    {
        homeobject.tweet_link.click();
        homeobject.text_area_tweet.sendKeys(text);
        homeobject.tweet_button.click();
        Assert.assertTrue(homeobject.alert_same_tweet.isDisplayed());
        homeobject.close_tweet.click();
        homeobject.discard_button.click();
    }
    @Test(priority = 5)
    public void send_tweet_with_gif() throws InterruptedException {
        homeobject.send_tweet_include_gif();
        homeobject.tweet_button.click();
        Assert.assertTrue(homeobject.message.isDisplayed());
    }
    /*
    @Test(priority = 5)
    public void can_not_include_gif_and_image_in_one_tweet() throws InterruptedException {

      homeobject.send_tweet_include_gif();
    System.out.println(homeobject.gallery_button.getText());
     // Assert.assertFalse(homeobject.gallery_button.isDisplayed());
      homeobject.tweet_button.click();
    }
    @Test(priority = 6)
    public void can_not_include_gif_and_poll_in_one_tweet() throws InterruptedException {
        homeobject.send_tweet_include_gif();
        Assert.assertFalse(homeobject.poll_button.isEnabled());
        homeobject.tweet_button.click();
    }*/
    @Test(priority = 8)
    public void send_tweet_with_poll() throws InterruptedException {
        String question= RandomStringUtils.randomAlphabetic(5);
        String  choice1=RandomStringUtils.randomAlphabetic(3);
        String choice2=RandomStringUtils.randomAlphabetic(3);
        homeobject.send_tweet_include_poll(question,choice1,choice2);
        Assert.assertTrue(homeobject.message.isDisplayed());

    }
    /*
    @Test(priority = 4)
    public void send_tweet_include_less_than_4_image()
    {
      //  homeobject.click_on_home();
        homeobject.send_tweet_include_image(System.getProperty("user.dir")+"\\images\\tweet1.png");
        homeobject.send_tweet_include_image(System.getProperty("user.dir")+"\\images\\tweet2.png");
        homeobject.send_tweet_include_image(System.getProperty("user.dir")+"\\images\\tweet3.png");
        homeobject.tweet_button.click();
        Assert.assertTrue(homeobject.message.isDisplayed());
    }
    @Test(priority = 5)
    public void send_tweet_include_equal_to_4_image()
    {
        homeobject.click_on_home();
        homeobject.send_tweet_include_image(System.getProperty("user.dir")+"\\images\\tweet1.png");
        homeobject.send_tweet_include_image(System.getProperty("user.dir")+"\\images\\tweet2.png");
        homeobject.send_tweet_include_image(System.getProperty("user.dir")+"\\images\\tweet3.png");
        homeobject.send_tweet_include_image(System.getProperty("user.dir")+"\\images\\tweet4.png");
        homeobject.tweet_button.click();
        Assert.assertTrue(homeobject.message.isDisplayed());
    }
    @Test(priority = 6)
    public void user_can_not_send_tweet_include_more_than_4_image()
    {
        homeobject.click_on_home();
        homeobject.send_tweet_include_image(System.getProperty("user.dir")+"\\images\\tweet1.png");
        homeobject.send_tweet_include_image(System.getProperty("user.dir")+"\\images\\tweet2.png");
        homeobject.send_tweet_include_image(System.getProperty("user.dir")+"\\images\\tweet3.png");
        homeobject.send_tweet_include_image(System.getProperty("user.dir")+"\\images\\tweet4.png");
       //homeobject.send_tweet_include_image(System.getProperty("user.dir")+"\\images\\tweet5.png");

        Assert.assertFalse(homeobject.gallery_button.isEnabled());
    }
    @Test(priority = 7)
    public void user_can_not_send_tweet_iclude_image_and_GIF()
    {
        homeobject.click_on_home();
        homeobject.send_tweet_include_image(System.getProperty("user.dir")+"\\images\\tweet1.png");
        Assert.assertFalse(homeobject.gif_button.isEnabled());
    }
    @Test(priority = 8)
    public void user_can_not_send_tweet_include_image_and_poll()
    {
        homeobject.click_on_home();
        homeobject.send_tweet_include_image(System.getProperty("user.dir")+"\\images\\tweet1.png");
        Assert.assertFalse(homeobject.poll_button.isEnabled());
    }*/

}
