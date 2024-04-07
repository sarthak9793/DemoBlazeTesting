package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.type.NullType;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;
import static utilities.Hooks.driver;

public class AddProductToCartSteps {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    @Given("The cart button is clickable")
    public void the_cart_button_is_clickable() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("cartur")));
    }
    @When("User clicks on the cart button")
    public void user_clicks_on_the_cart_button() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id("cartur")).click();
    }
    @Then("Cart page should be opened")
    public void cart_page_should_be_opened() throws InterruptedException {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        Thread.sleep(2000);
        String currentUrl = driver.getCurrentUrl();
        assertEquals("Cart page is not opened", "https://www.demoblaze.com/cart.html", currentUrl);
    }

    @Given("User is on product details page")
    public void user_is_on_product_details_page() throws InterruptedException {
        Thread.sleep(2000);
        driver.navigate().to("https://www.demoblaze.com/prod.html?idp_=1");
    }
    @When("User adds a product to the cart")
    public void user_adds_a_product_to_the_cart() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.linkText("Add to cart")).click();
    }
    @When("User accepts the alert")
    public void user_accepts_the_alert() throws InterruptedException {
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    @Then("Added product should be visible in the cart")
    public void the_added_product_should_be_visible_in_the_cart() throws InterruptedException {
//        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Samsung galaxy s6']")));
        driver.findElement(By.xpath("//td[text()='Samsung galaxy s6']"));
    }

    @When("User clicks on delete button of respective product")
    public void user_clicks_on_delete_button_of_respective_product() throws InterruptedException {
        Thread.sleep(2000);
        WebElement deleteBtn = driver.findElement(By.linkText("Delete"));
        deleteBtn.click();
    }
    @Then("Product should be removed from cart")
    public void product_should_be_removed_from_cart() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> productName = driver.findElements(By.xpath("//td[text()='Samsung galaxy s6']"));
        if(!productName.isEmpty()){
            throw new AssertionError("Product is still added to cart");
        }
    }

    @When("User clicks on Home page")
    public void user_clicks_on_home_page() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("Home")).click();
        Thread.sleep(1000);
    }

}
