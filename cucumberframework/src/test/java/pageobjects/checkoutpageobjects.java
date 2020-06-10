package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class checkoutpageobjects 
{
	
	@FindBy(xpath = "//a[@class='cart-icon']//img[contains(@class,'')]")
	public static WebElement kartIcon;
	
	@FindBy(xpath = "//div[@class='cart-preview active']//button[contains(@class,'')]")
	public static WebElement proceedtoCheckoutbutton;
	
	@FindBy(xpath = "//p[@class='product-name']")
	public static WebElement productnameinCheckoutpage;
	
	
}
