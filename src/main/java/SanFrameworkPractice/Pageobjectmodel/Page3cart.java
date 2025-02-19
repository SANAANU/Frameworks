package SanFrameworkPractice.Pageobjectmodel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import SanFrameworkPractice.Abstractcomponents.Abstractcomponent;

public class Page3cart extends Abstractcomponent{

	WebDriver d;
	
	public Page3cart (WebDriver d)
	{
		super(d);
		this.d=d;
		PageFactory.initElements(d, this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartproducts;
	public boolean cartproductlist(String Productname)
	{
		boolean match = cartproducts.stream()
			.anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(Productname));
		return match;
	}
	
	@FindBy(xpath="(//*[@type='button'])[2]")
	WebElement checkbutton;
	
	public page4selectcountry checkoutProduct()
	{
		checkbutton.click();
		page4selectcountry p4 = new page4selectcountry(d);
		return p4;
	}
}
