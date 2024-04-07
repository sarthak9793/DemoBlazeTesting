package StepDefinitions;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.Hooks.driver;

public class ViewProductDetailsSteps {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    @When("User clicks on product {int}")
    public void user_clicks_on_product(Integer int1) throws InterruptedException {
        System.out.println(STR."User clicks on product \{int1}");

        Thread.sleep(2000);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='tbodyid']/*")));

        String baseUrl = "prod.html?idp_=";
        String fullUrl = baseUrl + int1;

        driver.findElement(By.xpath("//a[@href='" + fullUrl + "']")).click();
    }

    @Then("Product details for product {int} should be visible")
    public void product_details_for_product_should_be_visible(Integer int1) throws InterruptedException {
        System.out.println(STR."Product details for product \{int1} should be visible");

        Thread.sleep(2000);

        driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[2]/h2[1]"));
        driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[2]/h3[1]"));
        driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[2]/div[1]/div[1]/div[1]/p[1]"));
        driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/img[1]"));

    }

}
