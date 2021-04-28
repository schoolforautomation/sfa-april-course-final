package tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import model.User;
import selenium.pages.HomePage;
import selenium.pages.LoginPage;
import selenium.pages.SignUpPage;

public class SignUpTest extends BaseTest {

    @Test
    public void signUpTest() {
        logger.info("Go to Sign Up page");
        LoginPage loginPage = goToLandingPage();
        SignUpPage signUpPage = loginPage.signUp();

        logger.info("Fill in the Sign Up form");
        User user = provideUser();
        loginPage = signUpPage.fillSignUpForm(user);

        logger.info("Login with the previously created user");
        HomePage homePage = loginPage.login(user.getEmail(), user.getPassword());

        logger.info("Verify the login was successful");
        Assert.assertTrue(homePage.getClockIcon().isDisplayed());
    }

    private User provideUser() {
        return User.builder()
                .firstName(RandomStringUtils.randomAlphabetic(5))
                .lastName(RandomStringUtils.randomAlphabetic(5))
                .password(RandomStringUtils.randomAlphabetic(5))
                .email(RandomStringUtils.randomAlphabetic(5) + "@test.com")
                .address(RandomStringUtils.randomAlphabetic(5))
                .phone(RandomStringUtils.randomNumeric(10)).build();
    }
}
