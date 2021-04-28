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
public class TablePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"main\"]/div/section/div/table/tbody/tr/td[3]")
    private List<WebElement> priceCells;

    @FindBy(xpath = "//*[@id=\"main\"]/div/section/div/table/tfoot/tr/td[2]")
    private WebElement totalCell;

    public TablePage(final WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public int getPriceTotal() {
        int sum = 0;

        for (WebElement priceCell : getPriceCells()) {
            sum += Integer.parseInt(priceCell.getText());
        }

        return sum;
    }

    public int getTotal() {
        return Integer.parseInt(getTotalCell().getText());
    }
}
