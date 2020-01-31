package SeleniumFunctionalTests.LieferandoPages;

import SeleniumFunctionalTests.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RestaurantPage extends PageObject {
    public RestaurantPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h1")
    WebElement inscription;

    @FindBy(xpath = "//*[@id=\"isidedishpulldown_O15NO1PQ3N\"]")
    WebElement pullDownMenu;

    @FindBy(id = "ibasketproductnrspanOP07R3NPQ")
    WebElement quantityNumber;

    @FindBy(className = "button-add-sidedish")
    WebElement addQuantity;

    @FindBy(className = "button-remove-sidedish")
    WebElement removeQuantity;

    @FindBy(xpath = "//*[@id=\"isidedishselectionformOP07R3NPQ\"]/div[2]/div[2]/button")
    WebElement cartButton;

    public String displayOfInscription() {
        return inscription.getText();
    }

    public void selectionOfMenuItem(String userMeal, String userAddon, String userDrink, int userQuantity) {

        selectionOfDish(userMeal);
        selectionOfAddons(userAddon);
        this.pullDownMenu.click();
        selectionOfDrink(userDrink);
        selectionOfDishQuantity(userQuantity);
    }

    public void selectionOfDish(String userMeal) {
        List<WebElement> mealBoxes = driver.findElements(By.className("meal-name"));

        mealBoxes.forEach((x) -> {
            if (x.getText().contains(userMeal))
                x.click();
        });
    }

    public void selectionOfAddons(String userAddon) {
        List<WebElement> checkBoxItems = driver.findElements(By.className("checkbox-inline"));

        checkBoxItems.forEach((x) -> {
            if (x.getText().contains(userAddon))
                x.click();
        });
    }

    public void selectionOfDrink(String userDrink) {
        List<WebElement> pullDownMenuItems = driver.findElements(By.className("pulldown"));

        pullDownMenuItems.forEach((x) -> {
            if (x.getText().contains(userDrink))
                x.click();
        });
    }

    public void selectionOfDishQuantity(int userQuantity) {
        int number = Integer.parseInt(quantityNumber.getText());
        if (number < userQuantity) {
            addQuantity.click();
        } else if (number > userQuantity) {
            removeQuantity.click();
        } else {
            cartButton.click();
        }
    }
}
