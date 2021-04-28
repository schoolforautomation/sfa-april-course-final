package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginPage extends BasePage {

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"login-form\"]/input[3]")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"banner\"]/div[2]/a")
    private WebElement signUpLink;

    public LoginPage(final WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public SignUpPage signUp() {
        getSignUpLink().click();

        return new SignUpPage(getWebDriver());
    }

    public HomePage login(String email, String password) {
        getEmailInput().sendKeys(email);
        getPasswordInput().sendKeys(password);
        getSubmitButton().click();

        return new HomePage(getWebDriver());
    }
}
