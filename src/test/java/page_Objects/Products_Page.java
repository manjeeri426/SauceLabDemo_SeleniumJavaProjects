package page_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Products_Page {
	WebDriver ldriver;
	public Products_Page(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver,this);
	}
	
	@FindBy(xpath="//div[3]//div[2]//div[2]//div[1]")
	public WebElement product1_price;
	
	@FindBy(xpath="//div[4]//div[2]//div[2]//div[1]")
	public WebElement product2_price;
	
	@FindBy(id="checkout")
	public WebElement checkout;
}
