package qa.page.abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Mahadeva.ZFramework.pageobjects.CartPage;

public class AbstractComponents {
	
	
   public WebDriver driver;
	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
 @FindBy(xpath="//button[@routerlink=\"/dashboard/cart\"]")
 WebElement addcart;
 
 
 
 // [routerlink*='myorders']
	public void waitForElementToAppesr(By findBy) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
}
	
	public void waitForWebElementToAppesr(WebElement findB) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.invisibilityOf(findB));
}
	
	public CartPage goToCartPage() {
		addcart.click();
		CartPage cartpage=new CartPage(driver);
		return cartpage;
	}
	
	public void waitForEelemnetToDisappear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
}