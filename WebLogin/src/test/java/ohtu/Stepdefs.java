package ohtu;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Stepdefs {

    WebDriver driver;
    String baseUrl = "http://localhost:4567";

    @Given("^login is selected$")
    public void login_selected() throws Throwable {
        if (this.driver == null) {
            System.setProperty("webdriver.chrome.driver", "/home/janantik/git/ohtu-viikko4/chromedriver");
            this.driver = new ChromeDriver();
        }
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();
    }

    @When("^username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
    public void username_and_password_are_given(String username, String password) throws Throwable {
        usernameAndPassword(username, password);
    }

    private void usernameAndPassword(String username, String password) {
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();
    }

    private void newUser(String username, String password) {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "/home/janantik/git/ohtu-viikko4/chromedriver");
            this.driver = new ChromeDriver();
        }
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText(("register new user")));
        element.click();
        element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(password);
//        element.findElement(By.name("signup"));
        element.submit();
    }

    @When("^nonexistent username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
    public void nonexistent_username_and_password_are_given(String username, String password) throws Throwable {
        usernameAndPassword(username, password);
    }

    public void system_will_respond(String pageContent) throws Throwable {
        assertTrue(driver.getPageSource().contains(pageContent));
    }

    @When("^correct username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
    public void username_correct_and_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }

    @When("^correct username \"([^\"]*)\" and incorrect password \"([^\"]*)\" are given$")
    public void username_and_incorrect_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }

    @Then("^user is logged in$")
    public void user_is_logged_in() throws Throwable {
        pageHasContent("Ohtu Application main page");
    }

    @Then("^user is not logged in and error message is given$")
    public void user_is_not_logged_in_and_error_message_is_given() throws Throwable {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("^new user is selected$")
    public void new_user_is_selected() throws Throwable {
        if (this.driver == null) {
            System.setProperty("webdriver.chrome.driver", "/home/janantik/git/ohtu-viikko4/chromedriver");
            this.driver = new ChromeDriver();
        }
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
    }
    @Given("^user with username \"([^\"]*)\" and password \"([^\"]*)\" is unsuccesfully created$")
    public void user_with_username_and_password_is_unsuccesfully_created(String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        newUser(arg1, arg2);
    }

    @When("^incorrect username \"([^\"]*)\" and incorrect password \"([^\"]*)\" are given$")
    public void incorrect_username_and_incorrect_password_are_given(String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        usernameAndPassword(arg1,arg2);
    }

    @Given("^user with username \"([^\"]*)\" with password \"([^\"]*)\" is succesfully created$")
    public void user_with_username_with_password_is_succesfully_created(String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       
        if(this.driver == null) {
            System.setProperty("webdriver.chrome.driver", "/home/janantik/git/ohtu-viikko4/chromedriver");
            driver = new ChromeDriver();
        }
         this.driver.get(baseUrl);
         WebElement e  = driver.findElement(By.linkText("register new user"));
         e.click();
         newUser(arg1, arg2);
        driver.get(baseUrl);
    }

    @When("^new username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
    public void new_username_and_password_are_given(String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        newUser(arg1, arg2);
    }

    @Then("^user is created and logged in$")
    public void user_is_created_and_logged_in() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        try {Thread.sleep(1200);} catch(Exception e) {}
        pageHasContent("info for newbie");
    }

    @When("^new user is again selected$")
    public void new_user_is_again_selected() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        if (this.driver == null) {
            System.setProperty("webdriver.chrome.driver", "/home/janantik/git/ohtu-viikko4/chromedriver");
            this.driver = new ChromeDriver();
        }
        WebElement el = driver.findElement(By.partialLinkText("continue"));
        el.click();
        el = driver.findElement(By.linkText("logout"));
        el.click();
        el = driver.findElement(By.linkText("register new user"));
        el.click();

    }

    @Then("^user is not created and error \"([^\"]*)\" is reported$")
    public void user_is_not_created_and_error_is_reported(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        try {
            Thread.sleep(2200);
        } catch (Exception e) {
        }
        pageHasContent(arg1);
    }

    @Before
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "/home/janantik/git/ohtu-viikko4/chromedriver");
//
//        this.driver = new ChromeDriver();

    }

    /* helper methods */
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }

    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();
    }
}
