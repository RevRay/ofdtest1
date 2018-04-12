package ru.devray.ofdtest.util;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class WDriver {

    //wrapper class that provides public API
    //wraps an instance of Selenium WebDriver
    private static WDriver wd;

    //selenium core, isolated and encapsulated by wrapper
    private static WebDriver driver;


    private WebDriverWait wait;

    public static WDriver getInstance() {
        if (wd == null) {
            wd = new WDriver();
        }
        return wd;
    }

    public void startChromeDriver(){
        System.setProperty("webdriver.chrome.driver", new File("").getAbsolutePath() + "/bin/ChromeDriver_Linux_64");
        //System.setProperty("webdriver.chrome.driver", new File("").getAbsolutePath() + "/bin/ChromeDriver_32.exe");

        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/google-chrome-stable"); //unix
        options.addArguments("--no-sandbox", "--start-maximized", "--disable-infobars");

        driver = new ChromeDriver(options);
    }

    public void startFirefoxDriver(){
        System.setProperty("webdriver.gecko.driver", new File("").getAbsolutePath() + "/bin/geckodriver");

        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("/usr/bin/firefox");

        driver = new FirefoxDriver();
    }

    //TODO implement
    public void startIEDriver(){
        throw new UnsupportedOperationException();
    }

    //WRAPPER API FOLLOWS

    public void get(String address){
        driver.get(address);
    }

    public void get(String address, String user, String pass){
        //user-password credentials insertion
        String start = address.substring(0, address.indexOf("//")+2);
        String end = address.substring(address.indexOf("//")+2, address.length());

        String authAddress = String.format("%s%s:%s@%s", start, user, pass, end);
        this.get(authAddress);
    }

    public void refresh(){
        driver.navigate().refresh();
    }

    public WebElement findElement(String xpath){
        wait = new WebDriverWait(driver, 3);
        WebElement element = null;
        int count = 3;
        while (count > 0) {
            count--;
            try {
                element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
                element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

                return element;
            } catch (WebDriverException e) {
                throw new TimeoutException("Element not found");
            }
        }
        throw new TimeoutException("Element not found");
    }

    public void quit(){
        driver.quit();
    }

}
