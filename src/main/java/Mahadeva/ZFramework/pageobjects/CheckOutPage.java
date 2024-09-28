package Mahadeva.ZFramework.pageobjects;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.page.abstractcomponents.AbstractComponents;

public class CheckOutPage extends AbstractComponents{
WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[placeholder=\"Select Country\"]")
	WebElement country;

	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement selectCountry;

	@FindBy(xpath="//a[@class='btnn action__submit ng-star-inserted']")
	WebElement Submit;
	
	@FindBy(xpath="//a[text()='Place Order ']")
	WebElement toSubmit;
	 By result=By.cssSelector(".ta-results");
	 
	public void SelectCountry(String countryName) {
		Actions a=new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		//waitForElementToAppesr(result);
		selectCountry.click();
	}

	public ConfirmationPage submitOrder() {
//		Actions a=new Actions(driver);
//		a.moveToElement(driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']"))).click();
		//toSubmit.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", toSubmit);
		 return new ConfirmationPage(driver);
	}
}
