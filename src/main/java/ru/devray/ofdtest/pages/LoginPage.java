package ru.devray.ofdtest.pages;

import org.junit.Assert;

public class LoginPage extends AbstractPage {

    String pageURL = "https://lk.platformaofd.ru";

    //page-specific locators
    //String elementForCheck = "//section[@id='section-login']/div/h2/span[contains(text(),'Личный кабинет клиента')]";
    String elementForCheck = "//span[contains(text(),'Личный кабинет клиента')]";
    String enterButton = "//button[@id='login_link_id']";
    String loginField = "//input[@id='j_username']";
    String passwordField = "//input[@id='j_password']";
    String loginButton = "//button[contains(text(),'Войти')]";
    String smsCodeField = "//input[@id='code']";
    String sendSmsCodeButton = "//button[text()='Ок']";

    public void checkPage() {
        Assert.assertTrue(wd.findElement(elementForCheck).isDisplayed());
    }

    public void open() {
        wd.get(pageURL);
    }

    public void clickEnterButton(){
        wd.findElement(enterButton).click();
    }

    public void setLoginField(String login){
        wd.findElement(loginField).clear();
        wd.findElement(loginField).sendKeys(login);
    }

    public void setPasswordField(String password){
        wd.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton(){
        wd.findElement(loginButton).click();
    }

    public void setSmsCodeField(String smsCode){
        wd.findElement(smsCodeField).sendKeys(smsCode);
    }

    public void clickSendSmsCodeButton(){
        wd.findElement(sendSmsCodeButton).click();
    }

    public void logIn(String login, String password, String smsCode) {
        checkPage();
        clickEnterButton();
        setLoginField(login);
        setPasswordField(password);
        clickLoginButton();
        setSmsCodeField(smsCode);
    }
}
