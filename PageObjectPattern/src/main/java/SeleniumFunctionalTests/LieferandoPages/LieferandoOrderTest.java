package SeleniumFunctionalTests.LieferandoPages;

import SeleniumFunctionalTests.FunctionalTest;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LieferandoOrderTest extends FunctionalTest {
    String url = "https://www.lieferando.de/";
    RestListPage restListPage;
    String userQuery = "Balli Holzkohlegrill Restaurant";
    String userMeal = "Dürüm Menü";
    String userAddon = "mit Kräutersauce";
    String userDrink = "Fanta Exotic 0,33l";
    int numberOfDishes = 2;

    @Test
    public void orderingTest() throws InterruptedException {
        driver.get(url);
        MainPage mainPage = new MainPage(driver);
        Thread.sleep(2000);

        restListPage = mainPage.clickButton();
        Thread.sleep(2000);
        assertTrue(restListPage.displayOfSelectLine());

        RestaurantPage restaurantPage = restListPage.searchNameOfRest(userQuery);
        Thread.sleep(2000);
        assertEquals(userQuery, restaurantPage.displayOfInscription());

        restaurantPage.selectionOfMenuItem(userMeal, userAddon, userDrink, numberOfDishes);
        Thread.sleep(2000);
    }
}
