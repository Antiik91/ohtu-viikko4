package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/home/janantik/git/ohtu-viikko4/chromedriver");
        WebDriver driver = new ChromeDriver();
        Random rndm = new Random();
        int luku = rndm.nextInt();
        driver.get("http://localhost:4567");

        sleep(2);

        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));

        sleep(2);
        element.submit();

        sleep(3);

        element = driver.findElement(By.linkText("logout"));
        element.click();

        sleep(2);
        element = driver.findElement(By.linkText("login"));
        element.click();
        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("Jokumuu");

        sleep(2);
        element.submit();
        sleep(3);
        element = driver.findElement(By.name("username"));
        element.sendKeys("IhmeTyyppi");
        element = driver.findElement(By.name("password"));
        element.sendKeys("Jokumuu");
        sleep(2);
        element.submit();
        sleep(3);
        element = driver.findElement(By.linkText("back to home"));
        element.click();
        sleep(2);
        element = driver.findElement(By.linkText("register new user"));
        element.click();
        sleep(2);
        element = driver.findElement(By.name("username"));
        element.sendKeys("Pätkä" + luku);
        element = driver.findElement(By.name("password"));
        element.sendKeys("hyäsalasana");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("hyväsalasana");
        sleep(2);
        element.submit();
        sleep(3);
        element = driver.findElement(By.partialLinkText("continue"));
        sleep(1);
        element.click();
        sleep(2);
        element = driver.findElement(By.linkText("logout"));
        sleep(1);
        element.click();
        sleep(2);
        driver.quit();
    }

    private static void sleep(int n) {
        try {
            Thread.sleep(n * 1000);
        } catch (Exception e) {
        }
    }
}
