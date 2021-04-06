package com.task.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }
  //  @FindBy(xpath = "(//a[@role='link'])[8]")
    @FindBy(linkText = "Tweet")
    public WebElement tweet_link;

    @FindBy(xpath = "//div[@data-testid='tweetTextarea_0']")
    public WebElement text_area_tweet;

    @FindBy(xpath = "(//div[@class='css-901oao r-1awozwy r-jwli3a r-6koalj r-18u37iz r-16y2uox r-1qd0xha r-a023e6 r-b88u0q r-1777fci r-rjixqe r-dnmrzs r-bcqeeo r-q4m81j r-qvutc0'])[1]")
    public  WebElement tweet_button;

    @FindBy(xpath = "(//div[@class='css-901oao r-1awozwy r-jwli3a r-6koalj r-18u37iz r-16y2uox r-1qd0xha r-a023e6 r-b88u0q r-1777fci r-rjixqe r-dnmrzs r-bcqeeo r-q4m81j r-qvutc0'])[2]")
    public WebElement tweet_btn;

    @FindBy(xpath = "(//div[@class='css-901oao r-1awozwy r-13gxpu9 r-6koalj r-18u37iz r-16y2uox r-1qd0xha r-a023e6 r-b88u0q r-1777fci r-rjixqe r-dnmrzs r-bcqeeo r-q4m81j r-qvutc0'])[2]")
    public WebElement gallery_button;

    @FindBy(xpath = "(//div[@class='css-901oao r-1awozwy r-13gxpu9 r-6koalj r-18u37iz r-16y2uox r-1qd0xha r-a023e6 r-b88u0q r-1777fci r-rjixqe r-dnmrzs r-bcqeeo r-q4m81j r-qvutc0'])[3]")
    public WebElement gif_button;

    @FindBy(xpath = "(//div[@class='css-901oao r-1awozwy r-13gxpu9 r-6koalj r-18u37iz r-16y2uox r-1qd0xha r-a023e6 r-b88u0q r-1777fci r-rjixqe r-dnmrzs r-bcqeeo r-q4m81j r-qvutc0'])[4]")
    public WebElement poll_button;

    @FindBy(xpath = "//div[@data-testid='toast']")
    public WebElement message;

 //   @FindBy(xpath = "(//span[@class='css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0'])[3]")
    @FindBy(linkText = "Home")
    public WebElement home_link;

    @FindBy(xpath = "(//div[@role='button'])[1]")
    public WebElement close_tweet;


    @FindBy(xpath = "(//img[@class='css-9pa8cd'])[1]")
    public WebElement choose_type_of_gif;

    @FindBy(xpath = "(//img[@class='css-9pa8cd'])[1]")
    public WebElement gif_image;

    @FindBy(xpath = "//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']")
    public WebElement ask_question;

    @FindBy(name = "Choice1")
    public WebElement choice1;

    @FindBy(name = "Choice2")
    public WebElement choice2;

    @FindBy(id="Days")
    public  WebElement days;

    @FindBy(id="Hours")
    public  WebElement hours;

    @FindBy(id="Minutes")
    public WebElement minutes;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement alert_same_tweet;

    @FindBy(xpath = "//div[@class='css-901oao r-1awozwy r-18jsvk2 r-6koalj r-18u37iz r-16y2uox r-1qd0xha r-a023e6 r-b88u0q r-1777fci r-rjixqe r-dnmrzs r-bcqeeo r-q4m81j r-qvutc0']")
    public WebElement discard_button;



    public void click_on_home()
    {
        home_link.click();
    }

    public void click_tweet_link()
    {
        tweet_link.click();
    }
    public void set_tweet_text(String text)
    {
        text_area_tweet.sendKeys(text);
    }
    public void click_on_tweet_btn() {
        tweet_btn.click();
    }
    public void write_tweet(String text)
    {
        tweet_link.click();
        text_area_tweet.sendKeys(text);
        tweet_button.click();
    }
    public void close_tweet_screen()
    {
        close_tweet.click();
    }
    public void send_tweet_include_image(String link_image)
    {
        tweet_link.click();
        gallery_button.sendKeys(link_image);
    }
    public void send_tweet_include_gif() throws InterruptedException {
        tweet_link.click();
        gif_button.click();
        Thread.sleep(2000);
        choose_type_of_gif.click();
        Thread.sleep(2000);
        gif_image.click();
    }
    public void send_tweet_include_poll(String question,String ch1,String ch2) throws InterruptedException {
        tweet_link.click();
        poll_button.click();
        ask_question.sendKeys(question);
        choice1.sendKeys(ch1);
        choice2.sendKeys(ch2);
        Select select_days=new Select(days);
        days.click();
       select_days.selectByVisibleText("1");
        Select select_hours=new Select(hours);
        hours.click();
       select_hours.selectByVisibleText("0");
        Select select_minutes=new Select(minutes);
        minutes.click();
        select_minutes.selectByVisibleText("0");
        Thread.sleep(3000);
        tweet_button.click();
    }

}
