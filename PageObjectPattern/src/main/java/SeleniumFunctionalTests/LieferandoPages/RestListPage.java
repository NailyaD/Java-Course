package SeleniumFunctionalTests.LieferandoPages;

import SeleniumFunctionalTests.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class RestListPage extends PageObject {
    public RestListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "irestaurantsearchstring-middle")
    WebElement selectRestLine;

    public boolean displayOfSelectLine() {
        return selectRestLine.isDisplayed();
    }

    public RestaurantPage searchNameOfRest(String userQuery) {
        try {
            List<WebElement> links = driver.findElements(By.className("restaurantname"));

            links.forEach((x) -> {
                if (x.getText().equals(userQuery))
                    x.click();
            });
        } catch (StaleElementReferenceException e) {
            return new RestaurantPage(driver);
        }
        return new RestaurantPage(driver);
    }

}
