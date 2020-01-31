package SeleniumFunctionalTests.LieferandoPages;

import SeleniumFunctionalTests.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageObject {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"submit_deliveryarea\"]")
    WebElement submitButton;

    public RestListPage clickButton() throws InterruptedException {
        submitButton.click();
        Thread.sleep(4000);
        return new RestListPage(driver);
    }


}
