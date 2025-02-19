package SanFrameworkPractice.Pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SanFrameworkPractice.Abstractcomponents.Abstractcomponent;

public class Page1Login extends Abstractcomponent {
	WebDriver d;

	public Page1Login(WebDriver d) {
		super(d);
		this.d = d;
		PageFactory.initElements(d, this);
	}

//	WebElement Username = d.findElement(By.id("userEmail"));
//	WebElement Userpassword = d.findElement(By.id("userPassword"));
//	WebElement LoginButton = d.findElement(By.id("login"));

	@FindBy(id="userEmail")
	WebElement Username1;
	
	@FindBy(id="userPassword")
	WebElement Userpassword1; 
	
	@FindBy(id="login")
	WebElement LoginButton1;
	
	public page2Productcatalog pag1Actions(String name, String password) {
		Username1.sendKeys(name);
		Userpassword1.sendKeys(password);
		LoginButton1.click();
		
		//here creating next page object in this method and returning it and utilize it in main class with creating 
		//once again the object got page2Productcatalog.
		page2Productcatalog catalog = new page2Productcatalog(d);
		return catalog;
	}
	
	public void LaunchChorme()
	{
		
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		
	}

	public void gotoURL() {
		d.get("https://rahulshettyacademy.com/client/");
	}
}
