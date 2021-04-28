package base;

import org.testng.annotations.BeforeTest;

import selenium.pages.LoginPage;

public class LoginBaseTest extends BaseTest {

    @BeforeTest
    public void login() {
        LoginPage loginPage = goToLandingPage();
        loginPage.login("cornel.rantes@endava.com", "test1234");
    }
}
