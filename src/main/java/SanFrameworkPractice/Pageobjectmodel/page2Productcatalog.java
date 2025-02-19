package SanFrameworkPractice.Pageobjectmodel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SanFrameworkPractice.Abstractcomponents.Abstractcomponent;

public class page2Productcatalog extends Abstractcomponent {

	WebDriver d;

	public page2Productcatalog(WebDriver d) {
		super(d);
		this.d = d;
		PageFactory.initElements(d, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> cards;

	By waitby = By.cssSelector(".mb-3");
	By Addcart = By.cssSelector(".card-body button:last-of-type");
	By toastmsg = By.cssSelector("#toast-container");
	By Disappearanimy = By.cssSelector(".ng-animating");

	public List<WebElement> getCards() {
		visibilityOfAllElementsLocated(waitby);
		return cards;
	}

	List<WebElement> p;

	public WebElement getProductname(String Productname) {
		WebElement p = cards.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(Productname)).findFirst()
				.orElse(null);
		return p;
	}

	public void AddtoCart(String Productname) {
		WebElement p = getProductname(Productname);
		p.findElement(Addcart).click();
		visibilityOfAllElementsLocated(toastmsg);
		invisibilityOfElement(Disappearanimy);
	}

}