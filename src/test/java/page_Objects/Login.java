package page_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	WebDriver ldriver;
	public Login(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver,this);
	}
	
	@FindBy(id="user-name")
	public WebElement username;
	
	@FindBy(id="password")
	public WebElement password;
	
    @FindBy(id="login-button" )
	public WebElement login_button;
	
	 

}
