import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheeseCakeAreOnThePage {
    @Test

    public void listCheesecakes() throws InterruptedException {
        WebDriver driver;
        System.setProperty("webdriver.gecko.driver", "/Users/felisia/programming/geckodriver");
        driver = new FirefoxDriver();
        driver.get("http://www.thecheesecakefactory.com");

        System.out.println("before wait");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("after waut");

        driver.findElement(By.xpath("//a[@id='closeBtn']")).click();
        System.out.println("close button is closed");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("wait until menu is displayed");

        driver.findElement(By.xpath("//a[@href='/menu/']")).click();
        System.out.println("menu is clicked");

        System.out.println("wait until dessert are displayed");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@href='/menu/']")).click();
        System.out.println("menu is clicked for the second time");
        Thread.sleep(5000);

        driver.findElement(By.xpath("//a[@href='/menu/desserts/']")).click();
        System.out.println("desserts are clicked");
        Thread.sleep(5000);

        driver.findElement(By.xpath("//a[@href='/menu/desserts/']")).click();
        System.out.println("desserts are clicked for the second time");

        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@href='/menu/desserts/cheesecakes/']")).click();
        Thread.sleep(5000);

        List<WebElement> cheesecakes = driver.findElements(By.xpath("//a[contains(@href,'/menu/desserts/cheesecakes')]"));

        System.out.println(cheesecakes.size() + " cheesecakes:");

        for (int i=0; i < cheesecakes.size(); i++) {

            System.out.println(i+1 + ". " + cheesecakes.get(i).getText());

        }

    }

}
