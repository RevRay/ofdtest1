package ru.devray.ofdtest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.devray.ofdtest.pages.CabinetPage;
import ru.devray.ofdtest.pages.LoginPage;
import ru.devray.ofdtest.util.EnvironmentData;
import ru.devray.ofdtest.util.WDriver;

public class LoginTest {

    WDriver wd;

    //TODO move environment data to *.ini
    String startURL = "https://lk.platformaofd.ru/web/api/test/login";

    String auth_user = "t.developer";
    String auth_password = "Eigh4tha";

    String web_login = "79001000001";
    String web_password = "testtesttest123";
    String web_code = "12345";

    @Before
    public void setUp(){
        wd = WDriver.getInstance();
        wd.startChromeDriver();
    }

    @Test
    public void testIni(){
        System.out.println(EnvironmentData.getInstance().loadValue("auth_user"));
    }

    @Test
    public void testLogin(){
        LoginPage loginPage = new LoginPage();

        loginPage.open();
        loginPage.logIn(web_login, web_password, web_code);

        CabinetPage cabinetPage = new CabinetPage();

        cabinetPage.checkPage();
    }


    @Test
    public void testBasicAuthorization(){
        wd.get(startURL, auth_user, auth_password);
    }

    @After
    public void tearDown(){
        wd.quit();
    }
}
