package com.task.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import utilities.Helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;

    static String configpath=System.getProperty("user.dir")+"\\src\\test\\java\\configuration\\config.properties"; // to get path for config properties file


    public TestBase() throws IOException {
        prop=new Properties();
        FileInputStream file=new FileInputStream(configpath);
        prop.load(file);

    }
    @BeforeTest
    public static void setDriver()
    {
        if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        else if (prop.getProperty("browser").equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }
        driver.get(prop.getProperty("URL"));           //to get url from config.properties and open it in browser
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);      //implicit wait to make page load and element
         driver.manage().window().maximize();              //to maximize window
    }
    @AfterMethod    //this method take screen shot when test fail and name it with method name and parameter of method
    public void take_ScreenShot_On_Failure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-"
                    + Arrays.toString(testResult.getParameters()) + ".png"));
        }

    }
  /* @AfterMethod  //this method take screenshot in failure but override picture if have more than fail
	public void take_ScreenShot_on_Failure(ITestResult result  ) throws Exception
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			System.out.println("fail will take screenshot");
			Helper.takescreenshot(driver,result.getName());
		}

	}*/

    @AfterSuite
    public void teardown()
    {
      //  driver.quit();

    }


    }

