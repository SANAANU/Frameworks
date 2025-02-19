package SanFrameworkPractice.Pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import SanFrameworkPractice.Abstractcomponents.Abstractcomponent;

public class Page5OrderplacedDetails extends Abstractcomponent{
	
	WebDriver d;
	public Page5OrderplacedDetails(WebDriver d) {
		super(d);
		this.d=d;
		PageFactory.initElements(d, this);
	}

	@FindBy(css=".hero-primary")
	WebElement msg;
	public void successmsg() 
	{
		Assert.assertEquals(msg.getText().equalsIgnoreCase("THANKYOU FOR THE ORDER."), true);
	}
	
	
}
