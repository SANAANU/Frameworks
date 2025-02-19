package SanFrameworkPractice.Pageobjectmodel;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.BaseTestMethod;

import SanFrameworkPractice.Abstractcomponents.Abstractcomponent;
import Santhosh.testcomponents.Basetests;
import io.github.bonigarcia.wdm.WebDriverManager;

public class class1_Loging extends Basetests {
	@Test
	public void Goo() throws IOException, InterruptedException
	{

		LaunchURL();	
		String Productname = "ADIDAS ORIGINAL";
		String Countryname = "INDIA";
		Page1Login p1 = new Page1Login(d);
		page2Productcatalog TestComponents=p1.pag1Actions("Arun1818@gmail.com", "Arun1818");

		// Page2 age2Productcatalog  
		//Page2 object is created in page 1 and using it directly in above "page2Productcatalog catalog"
		page2Productcatalog catalog = new page2Productcatalog(d);

		List<WebElement> cardsdetails = catalog.getCards();
		catalog.getProductname(Productname);
		catalog.AddtoCart(Productname);

		Abstractcomponent ab = new Abstractcomponent(d);
		Page3cart p3=ab.GotoCartpage();

		// page3 
		boolean match = p3.cartproductlist(Productname);
		Assert.assertTrue(match);
		page4selectcountry p4=p3.checkoutProduct();
		
		Page5OrderplacedDetails p5 =p4.CountryName(Countryname);
		p5.successmsg();

		d.close();
	}
}
