package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static utilities.Hooks.driver;

public class CheckOutAndBuySteps {

    @When("User clicks on the place order button")
    public void user_clicks_on_the_place_order_button() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();
    }
    @Then("Place Order popup should not appear")
    public void place_order_popup_should_not_appear() throws InterruptedException {
        Thread.sleep(2000);
        boolean isPopupVisible = driver.findElement(By.xpath("//label[text()='Credit card:']")).isDisplayed();
        assertFalse("Place order popup should not appear", isPopupVisible);
    }

    @Then("Place Order popup should appear")
    public void place_order_popup_should_appear() throws InterruptedException {
        Thread.sleep(2000);
        boolean isPopupVisible = driver.findElement(By.xpath("//label[text()='Credit card:']")).isDisplayed();
        assertTrue("Place order popup should appear", isPopupVisible);
    }

    //Scenario 3
    @When("User clicks on the purchase button")
    public void user_clicks_on_the_purchase_button() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[3]/button[2]")).click();
    }
    @Then("purchase should not be completed")
    public void purchase_should_not_be_completed() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> purchaseConfirmationDialog = driver.findElements(By.xpath("//h2[text()='Thank you for your purchase!']"));
        if(!purchaseConfirmationDialog.isEmpty()){
            throw new AssertionError("Purchase should not be completed");
        }
    }

    //Scenario 4
    @When("purchase should be completed")
    public void purchase_should_be_completed() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> purchaseConfirmationDialog = driver.findElements(By.xpath("//h2[text()='Thank you for your purchase!']"));
        if(purchaseConfirmationDialog.isEmpty()){
            throw new AssertionError("Purchase should not be completed");
        }
    }
    @Given("User fills all the fields")
    public void user_fills_all_the_fields() throws InterruptedException{
        Thread.sleep(2000);
        driver.findElement(By.id("name")).sendKeys("Sarthak Srivastava");
        driver.findElement(By.id("country")).sendKeys("India");
        driver.findElement(By.id("city")).sendKeys("Delhi");
        driver.findElement(By.id("card")).sendKeys("5555 5555 5555 5555");
        driver.findElement(By.id("month")).sendKeys("12");
        driver.findElement(By.id("year")).sendKeys("29");
    }

    //Scenario 5
    @Given("User only fills name and credit card")
    public void user_only_fills_name_and_credit_card () throws InterruptedException{
        Thread.sleep(2000);
        driver.findElement(By.id("name")).sendKeys("Sarthak Srivastava");
        driver.findElement(By.id("card")).sendKeys("5555 5555 5555 5555");
    }

    //Scenario 6
    @Then("Cart should be empty")
    public void cart_should_be_empty() throws InterruptedException{
        Thread.sleep(2000);
        List<WebElement> cartContent = driver.findElements(By.xpath("//td[1]")); //first cell of the cart table
        if (!cartContent.isEmpty()){
            throw new AssertionError("Cart should be empty");
        }
    }
    @Given("click on OK button on the purchase confirmation dialog")
    public void click_on_OK_button_on_the_purchase_confirmation_dialog() throws InterruptedException{
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[10]/div[7]/div[1]/button[1]")).click();
    }



}
