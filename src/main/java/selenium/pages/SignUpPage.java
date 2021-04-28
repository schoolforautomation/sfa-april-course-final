package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import lombok.Getter;
import lombok.Setter;
import model.User;

@Getter
@Setter
public class SignUpPage extends BasePage {

    @FindBy(id = "firstname")
    private WebElement firstNameInput;

    @FindBy(id = "lastname")
    private WebElement lastNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "address")
    private WebElement addressInput;

    @FindBy(id = "phone")
    private WebElement phoneInput;

    @FindBy(xpath = "//*[@id=\"banner\"]/div/form/input[7]")
    private WebElement submitButton;

    public SignUpPage(final WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public LoginPage fillSignUpForm(User user) {
        getFirstNameInput().sendKeys(user.getFirstName());
        getLastNameInput().sendKeys(user.getLastName());
        getPasswordInput().sendKeys(user.getPassword());
        getEmailInput().sendKeys(user.getEmail());
        getPhoneInput().sendKeys(user.getPhone());
        getAddressInput().sendKeys(user.getAddress());
        getSubmitButton().click();

        LoginPage loginPage = new LoginPage(getWebDriver());
        new WebDriverWait(getWebDriver(), 2)
                .until(ExpectedConditions.visibilityOf(loginPage.getSignUpLink()));

        return loginPage;
    }
}
