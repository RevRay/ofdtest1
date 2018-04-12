package ru.devray.ofdtest.pages;

import org.junit.Assert;

public class CabinetPage extends AbstractPage {

    String pageURL = "https://lk.platformaofd.ru/web/registration/certify";

    String elementForCheck = "//i[@id='profile_icon']";

    public void checkPage() {
        Assert.assertTrue(wd.findElement(elementForCheck).isDisplayed());
    }

    public void open() {
        wd.get(pageURL);
    }
}
