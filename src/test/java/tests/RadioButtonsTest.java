package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.LoginBaseTest;
import model.User;
import selenium.pages.HomePage;
import selenium.pages.RadioButtonsPage;

public class RadioButtonsTest extends LoginBaseTest {

    @Test
    public void radioButtonsTest() {
        logger.info("Go to Radio Buttons Page");
        HomePage homePage = new HomePage(getWebDriver());
        RadioButtonsPage radioButtonsPage = homePage.goToRadioButtonsPage();

        logger.info("Choose Priority");
        radioButtonsPage.choosePriority(1);
        radioButtonsPage.submitChoice();

        logger.info("Verify chosen Priority");
        Assert.assertEquals(radioButtonsPage.getChosenPriority(), "Normal Priority");

        User user = User.builder().firstName("ldsjalkjd").lastName(":lkhakjsad").password("kdsjahsda").email("jgjagda@dlsajlkda.com").phone("98437284432")
                .address("jkdsa lskajdlak ieorwu").build();
    }
}
