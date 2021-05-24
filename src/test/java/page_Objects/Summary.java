package page_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Summary {
	WebDriver ldriver;
	public Summary(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver,this);
	}
	
	@FindBy(xpath="//div[@class='summary_tax_label']") 
	public WebElement tax_pay;  // tax $ 3.20
	
	@FindBy(xpath="//div[@class='summary_total_label']")
	public WebElement total;
	
	@FindBy(id="finish") 
	public WebElement finish_button;
	
}
