package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.LoginBaseTest;
import selenium.pages.HomePage;
import selenium.pages.SelectPage;

public class SelectTest extends LoginBaseTest {

    @Test
    public void selectTest() {
        logger.info("Go to Select Page");
        HomePage homePage = new HomePage(getWebDriver());
        SelectPage selectPage = homePage.goToSelectPage();

        logger.info("Select Manufacturing category");
        selectPage.selectCategory(1);
        selectPage.submitSelectedValue();

        logger.info("Verify the selected category");
        Assert.assertEquals(selectPage.getSelectedCategory(), "Manufacturing");
    }
}
