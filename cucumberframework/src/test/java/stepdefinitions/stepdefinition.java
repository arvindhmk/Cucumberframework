package stepdefinitions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pageobjects.Homepageobjects;
import pageobjects.checkoutpageobjects;

public class stepdefinition {
	WebDriver driver;
	WebElement searchBox;
	WebElement resultElement;

	
	@Given("^User is on GreenKart landing page$")
	public void user_is_on_greenkart_landing_page() throws IOException 
	{

		driver = base.getDriver();
		PageFactory.initElements(driver, Homepageobjects.class);		
	}

    @When("^User searched for (.+) vegetable$")
    public void user_searched_for_vegetable(String name) 
	{
		
		searchBox = Homepageobjects.searchBox; 
				
				//driver.findElement(By.xpath("//input[@placeholder='Search for Vegetables and Fruits']"));
		searchBox.sendKeys(name);

	}

	@Then("^\"([^\"]*)\" results are displayed$")
	public void something_results_are_displayed(String strArg1) {

		WebDriverWait wait = new WebDriverWait(driver, 25);
		resultElement = Homepageobjects.searchResult;
				
		//driver.findElement(By.xpath("//div[@id='root']/div[@class='container']/div[@class='products-wrapper']//h4[@class='product-name']"));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(resultElement)));

		String resultText = resultElement.getText();
		System.out.println(resultText);

		Assert.assertFalse(resultText.contains(strArg1));

	}

	@And("^Add items to cart$")
	public void add_items_to_cart() throws InterruptedException {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver,20);
		//WebElement resultElement1 = Homepageobjects.incrementtQuantity; 
				
		//driver.findElement(By.cssSelector("a.increment"));
		WebElement resultElement1 = Homepageobjects.incrementtQuantity;
		
		wait.until(ExpectedConditions.elementToBeClickable(resultElement1));
		resultElement1.click();
		
		Homepageobjects.addcartButton.click();		
		//driver.findElement(By.xpath("//button[contains(text(),'ADD TO CART')]")).click();
	}

	@And("^user proceeded to checkout page for payment$")
	public void user_proceeded_to_checkout_page_for_payment() {
		
		PageFactory.initElements(driver, checkoutpageobjects.class);
		
		checkoutpageobjects.kartIcon.click();
		checkoutpageobjects.proceedtoCheckoutbutton.click();
		
		//driver.findElement(By.xpath("//a[@class='cart-icon']//img[contains(@class,'')]")).click();
		//driver.findElement(By.xpath("//div[@class='cart-preview active']//button[contains(@class,'')]")).click();
	}

    @Then("^verify selected (.+) items are displayed in check out page$")
    public void verify_selected_items_are_displayed_in_check_out_page(String name) 
    {
		resultElement = checkoutpageobjects.productnameinCheckoutpage;
				
				//driver.findElement(By.xpath("//p[@class='product-name']"));
		String resultText = resultElement.getText();
		System.out.println(resultText);

		Assert.assertTrue(resultText.contains(name));

	}

}
