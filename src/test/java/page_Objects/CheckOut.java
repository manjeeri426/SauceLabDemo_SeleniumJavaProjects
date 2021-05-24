package page_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOut {
	WebDriver ldriver;
	public CheckOut(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver,this);
	}
	
	@FindBy(id="first-name")
	public WebElement firstname;
	
	@FindBy(id="last-name")
	public WebElement lastname;
	
	@FindBy(id="postal-code")
	public WebElement postal_code;
	
	@FindBy(id="continue")
	public WebElement continue_button;
			
			

}
