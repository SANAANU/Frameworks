package SanFrameworkPractice.SaleniumFramework;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class class1_Loging {
	public static void main(String[] args) throws InterruptedException {

		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
		d.get("https://rahulshettyacademy.com/client/");
		d.findElement(By.id("userEmail")).sendKeys("Arun1818@gmail.com");
		d.findElement(By.id("userPassword")).sendKeys("Arun1818");
		d.findElement(By.id("login")).click();
		List<WebElement> cards = d.findElements(By.cssSelector(".mb-3"));
		WebElement p = cards.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL"))
				.findFirst().orElse(null);
		p.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		WebDriverWait wait = new WebDriverWait(d, java.time.Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		d.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
		List<WebElement> cartproducts = d.findElements(By.cssSelector(".cartSection h3"));
		boolean match = cartproducts.stream()
				.anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase("ADIDAS ORIGINAL"));
		Assert.assertTrue(match);

		d.findElement(By.xpath("(//*[@type='button'])[2]")).click();

		d.findElement(By.cssSelector("[placeholder='Select Country']")).click();
		d.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("INDIA");
		wait.until(ExpectedConditions.visibilityOf(d.findElement(By.cssSelector(".ta-results"))));
		d.findElement(By.xpath("(//*[contains(@class,'ta-item')])[2]")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) d;

		js.executeScript("window.scrollBy(0,100)");

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".action__submit")));

		d.findElement(By.cssSelector(".action__submit")).click();

		String msg = d.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(msg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

		d.close();
	}
}
