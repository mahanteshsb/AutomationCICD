package Mahadeva.ZFramework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.page.abstractcomponents.AbstractComponents;

public class ProductCateLogue extends AbstractComponents {
	WebDriver driver;

	public ProductCateLogue(WebDriver driver) {
		// initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// List<WebElement> Products =
	// driver.findElements(By.cssSelector(".card-body"));

	@FindBy(css = ".card-body")
	List<WebElement> Products;

	@FindBy(css = ".ng-animating")
	WebElement spinner;

	By productsBy = By.cssSelector(".card-body");
	By addCart = By.cssSelector(".card-body button:last-of-type");
	By totastMessage = By.cssSelector("#toast-container");

	public List<WebElement> getProductList() {
		//waitForElementToAppesr(productsBy);
		return Products;
	}

	public WebElement getProductByName(String productName) {
		WebElement prod = Products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);
		return prod;
	}

	public void adProductToCardr(String productName) {
		WebElement prod = getProductByName(productName);
		prod.findElement(addCart).click();
		waitForElementToAppesr(totastMessage);
		waitForEelemnetToDisappear(spinner);
	}

}
