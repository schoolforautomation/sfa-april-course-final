package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.LoginBaseTest;
import selenium.pages.HomePage;
import selenium.pages.TablePage;

public class TableTest extends LoginBaseTest {

    @Test
    public void tableTest() {
        logger.info("Go to Table Page");
        HomePage homePage = new HomePage(getWebDriver());
        TablePage tablePage = homePage.goToTablePage();

        logger.info("Compare prices");
        Assert.assertEquals(tablePage.getPriceTotal(), tablePage.getTotal());
    }
}
