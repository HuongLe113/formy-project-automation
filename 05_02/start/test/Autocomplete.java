import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Autocomplete {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/D://chromedriver_win32/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        //driver.get("https://formy-project.herokuapp.com/autocomplete");

        driver.get("https://developers.google.com/maps/documentation/javascript/examples/places-autocomplete-addressform");

        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement autocomplete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ship-address")));
        Actions actions= new Actions(driver);
        actions.moveToElement(autocomplete);
        autocomplete.sendKeys("1555 Park Blvd, Palo Alto, CA");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement autocompleteResult = driver.findElement(By.className("pac-item"));
        autocompleteResult.click();

        driver.quit();
    }
}
