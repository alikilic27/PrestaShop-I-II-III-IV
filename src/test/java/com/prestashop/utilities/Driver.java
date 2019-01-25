package com.prestashop.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Driver {

    /*
    Example and Singleton are example of this class and TestBase class
     */

    private static WebDriver driver;

    //nobody creates object other class, because of constructor
    //nobody calls the getDriver() method
    private Driver(){}

    public static WebDriver getDriver() {
        if (driver == null) {
            // command out because of the Configuration properties.
           String browser = ConfigurationReader.getProperty("browser");
           switch (browser){
               case "chrome":
                   WebDriverManager.chromedriver().setup();
                   driver = new ChromeDriver();
                   break;
               case "firefox":
                   WebDriverManager.firefoxdriver().setup();
                   driver = new FirefoxDriver();
                   break;
               case "ie":
                   throw new WebDriverException();
               case "edge":
                   WebDriverManager.edgedriver().setup();
                   driver = new EdgeDriver();
                   break;
               case "opera":
                   WebDriverManager.operadriver().setup();
                   driver = new OperaDriver();
                   break;
           }

        }
        return driver;
    }
    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }

}
