package page_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver ldriver;
	public HomePage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver,this);
	}
	
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	public WebElement Add_product1;
	
	@FindBy(id="add-to-cart-sauce-labs-bike-light")
	public WebElement Add_prduct2;
	
	@FindBy(id="shopping_cart_container")
	public WebElement shopping_cart_container;
	
	
			

}
