package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepageobjects 
{

	@FindBy(xpath = "//input[@placeholder='Search for Vegetables and Fruits']")
	public static WebElement searchBox;
	
	@FindBy(xpath = "//h4[contains(text(),'Beetroot - 1 Kg')]")
	public static WebElement searchResult;
	
	@FindBy(xpath = "//div[@id='root']/div[@class='container']//div[@class='product']/div[@class='stepper-input']/a[2]")
	public static WebElement incrementtQuantity;
	
	@FindBy(xpath = "//button[contains(text(),'ADD TO CART')]")
	public static WebElement addcartButton;
	
	
}
