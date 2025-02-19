package SanFrameworkPractice.Pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SanFrameworkPractice.Abstractcomponents.Abstractcomponent;
import net.bytebuddy.asm.Advice.Enter;

public class page4selectcountry extends Abstractcomponent{

	WebDriver d;
    
	public page4selectcountry(WebDriver d) {
		super(d);
		this.d = d;
		PageFactory.initElements(d, this);
	}
	//d.findElement(By.cssSelector("[placeholder='Select Country']")).click();
	
	@FindBy(css = "[placeholder='Select Country']")
	WebElement Placeholder;
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement EnterPlaceholder;
	
	
	
	@FindBy(xpath = "(//*[contains(@class,'ta-item')])[2]")
	WebElement selectname;
	
	By clickableplaceholder=By.cssSelector(".action__submit");
	
	@FindBy(css=".action__submit")
	WebElement PlaceOderbutton;
	
	public Page5OrderplacedDetails CountryName(String Countryname) throws InterruptedException
	{
		Placeholder.click();
		EnterPlaceholder.sendKeys(Countryname);
		visibilityOf(d.findElement(By.cssSelector(".ta-results")));
		selectname.click();
		ScrollbarDown();
		elementToBeClickable(clickableplaceholder);
		PlaceOderbutton.click();
		Page5OrderplacedDetails p5 = new Page5OrderplacedDetails(d);
		return p5;
	}
	
}
