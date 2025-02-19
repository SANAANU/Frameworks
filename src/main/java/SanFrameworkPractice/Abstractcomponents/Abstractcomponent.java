package SanFrameworkPractice.Abstractcomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SanFrameworkPractice.Pageobjectmodel.Page3cart;

public class Abstractcomponent {
	WebDriver d;

	public Abstractcomponent(WebDriver d) {
		this.d = d;
		PageFactory.initElements(d, this);
	}

	public void visibilityOfAllElementsLocated(By locator) {
		WebDriverWait wait = new WebDriverWait(d, java.time.Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public void invisibilityOfElement(By locator) {
		WebDriverWait wait = new WebDriverWait(d, java.time.Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	
	
	public void visibilityOf(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(d, java.time.Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void ScrollbarDown()
	{
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("window.scrollBy(0,200)");
	}
	
	public void elementToBeClickable(By locator)
	{
		WebDriverWait wait = new WebDriverWait(d, java.time.Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	@FindBy(css = "button[routerlink='/dashboard/cart']")
	WebElement cartbutton;

	public Page3cart GotoCartpage() {
		cartbutton.click();
		Page3cart p3 = new Page3cart(d);
		return p3;
	}
}
