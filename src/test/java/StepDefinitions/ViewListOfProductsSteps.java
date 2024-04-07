package StepDefinitions;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static utilities.Hooks.driver;

public class ViewListOfProductsSteps {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    @Then("User sees products")
    public void user_sees_products() throws InterruptedException {
        System.out.println("User sees products");

        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='tbodyid']/*")));

        WebElement parentDiv = driver.findElement(By.id("tbodyid"));
        List<WebElement> productDivs = parentDiv.findElements(By.className("productDivClass"));

        for (WebElement product : productDivs) {
            assertTrue(product.isDisplayed());
        }
    }
    @When("User clicks on the next button")
    public void user_clicks_on_the_next_button() {
        System.out.println("User clicks on the next button");

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='tbodyid']/*")));
        driver.findElement(By.id("next2")).click();
    }

    @When("User clicks on the {string} category")
    public void user_clicks_on_the_category(String string) throws InterruptedException {
        System.out.println(STR."User clicks on \{string} category");

        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(string)));
        driver.findElement(By.linkText(string)).click();
    }
}
