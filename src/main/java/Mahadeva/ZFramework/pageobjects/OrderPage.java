package Mahadeva.ZFramework.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.page.abstractcomponents.AbstractComponents;

public class OrderPage extends AbstractComponents {
	WebDriver driver;
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> ProductName;
	
	@FindBy(xpath="//button[text()=\"Checkout\"]")
	WebElement checkoutEle;
	
	//button[text()=\"Checkout\"]
	public OrderPage(WebDriver driver) {
		// initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public Boolean verifyOrderDisplay(String productName) {
		Boolean match = ProductName.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}

	
}
