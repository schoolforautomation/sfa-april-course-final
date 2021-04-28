package base;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import lombok.Getter;
import selenium.pages.LoginPage;

@Getter
public class BaseTest {

    private WebDriver webDriver;

    protected static Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeTest
    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }

    public LoginPage goToLandingPage() {
        webDriver.get("http://school-for-automation.tech/action/");

        return new LoginPage(getWebDriver());
    }

    @AfterTest
    public void tearDown() {
        webDriver.close();
    }
}
