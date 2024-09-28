package qa.testceses;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Mahadeva.ZFramework.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PassTest {

	public static void main(String[] args) throws InterruptedException {
		String productName = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\Dell\\eclipse-workspace3\\SeleniumFrameworkDesign\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		LandingPage landingpage = new LandingPage(driver);

		driver.findElement(By.id("userEmail")).sendKeys("mahanteshsb460@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("@Power123");
		driver.findElement(By.xpath("//input[@id=\"login\"]")).click();

//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".card-body")));
		List<WebElement> Products = driver.findElements(By.cssSelector(".card-body"));

		System.out.println(Products);
		WebElement prod = Products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);

		System.out.println(prod);
		Thread.sleep(5000);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
//driver.close();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#toast-container")));
//ng-animating
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.xpath("//button[@routerlink=\"/dashboard/cart\"]")).click();

		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = cartProducts.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		driver.findElement(By.xpath("//button[text()=\"Checkout\"]")).click();
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder=\"Select Country\"]")), "india").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();

		a.moveToElement(driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']"))).click()
				.perform();
		// driver.findElement(By.xpath("//a[@class='btnn action__submit
		// ng-star-inserted']")).click();
		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();

		System.out.println("Done");
	}

}
