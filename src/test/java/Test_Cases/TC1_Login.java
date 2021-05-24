package Test_Cases;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import page_Objects.CheckOut;
import page_Objects.HomePage;
import page_Objects.Login;
import page_Objects.Products_Page;
import page_Objects.Summary;

public class TC1_Login extends Base_Class{

	@Test
	public void login() throws InterruptedException
	{
	Login l=new Login(driver);
	l.username.sendKeys(username);
	l.password.sendKeys(password);
	l.login_button.click();
	
	Thread.sleep(10000);
	
	HomePage p=new HomePage(driver);
	p.Add_product1.click();
	
	Thread.sleep(2000);
	p.Add_prduct2.click();
	
	p.shopping_cart_container.click();
	
	Thread.sleep(5000);
	
	Products_Page t=new Products_Page(driver);
	String price1=t.product1_price.getText();
	String price2=t.product2_price.getText();
	
	String price_new1=price1.substring(1);
	String price_new2=price2.substring(1);
	
	double p1=ConvertStringToDouble(price_new1);
	double p2=ConvertStringToDouble(price_new2);
	
	System.out.println("prices are "+ p1 + "and"+ p2);
	
	t.checkout.click();
	
	Thread.sleep(6000);
	
	CheckOut c=new CheckOut(driver);
	
	c.firstname.sendKeys("hkjkj");
	Thread.sleep(2000);
	c.lastname.sendKeys("uuiu");
	Thread.sleep(2000);
	c.postal_code.sendKeys("767878");
	c.continue_button.click();
	Thread.sleep(2000);
	
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,550)");
	
	Thread.sleep(4000);
	Summary s=new Summary(driver);
	
	String tax=s.tax_pay.getText();
	System.out.println("tax is"+ tax);
	String[]tax_split=tax.split("\\$");
	for(String i:tax_split)
	{
		System.out.println("taxsplit is \n"+ i);
	} 
	
	String tax_2=tax_split[1];      
	System.out.print("tax value is"+ tax_2);
	
	double tax_new=ConvertStringToDouble(tax_2);
	
	String total=s.total.getText();
    String[] total_split=total.split("\\$");
    
   
    String total_2=total_split[1];
    System.out.print("total value is"+ total_2);
	
    double total_new=ConvertStringToDouble(total_2);
	
	System.out.println("Tax and total is"+ tax_new +"and"+ total_new);
	
	double calculated_total=p1+p2+tax_new;
	
	System.out.println("calculated total is"+ calculated_total);
	
	Assert.assertEquals(total_new,calculated_total);
	
	s.finish_button.click();
	
	}


	public double ConvertStringToDouble(String price1) {
		// TODO Auto-generated method stub
		double newprice=Double.parseDouble(price1);
		System.out.println("new price are------"+ newprice);
		return newprice;
	}
	
}
