package selenium.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RadioButtonsPage extends BasePage {

    @FindBy(name = "priority")
    private List<WebElement> radioButtons;

    @FindBy(xpath = "//*[@id=\"main\"]/div/section/input")
    private WebElement submitButton;

    @FindBy(id = "priority-value")
    private WebElement prioritySpan;

    public RadioButtonsPage(final WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void choosePriority(int index) {
        getRadioButtons().get(index).click();
    }

    public void submitChoice() {
        getSubmitButton().click();
    }

    public String getChosenPriority() {
        return getPrioritySpan().getText();
    }
}
