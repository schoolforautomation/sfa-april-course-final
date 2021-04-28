package selenium.pages;

import org.openqa.selenium.WebDriver;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasePage {

    private WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
