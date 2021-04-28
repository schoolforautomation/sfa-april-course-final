package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"one\"]/div/div/section[1]/a/i")
    private WebElement clockIcon;

    @FindBy(xpath = "//*[@id=\"one\"]/div/div/section[2]/a/i")
    private WebElement commentsIcon;

    @FindBy(xpath = "//*[@id=\"one\"]/div/div/section[3]/a/i")
    private WebElement userIcon;

    public HomePage(final WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public TablePage goToTablePage() {
        getClockIcon().click();

        return new TablePage(getWebDriver());
    }

    public RadioButtonsPage goToRadioButtonsPage() {
        getCommentsIcon().click();

        return new RadioButtonsPage(getWebDriver());
    }

    public SelectPage goToSelectPage() {
        getUserIcon().click();

        return new SelectPage(getWebDriver());
    }
}
