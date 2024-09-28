package Mahadeva.ZFramework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.page.abstractcomponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		// initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userEmail")
	WebElement Emails;

	@FindBy(id = "userPassword")
	WebElement Passwords;

	@FindBy(id = "login")
	WebElement LoginBtn;

//	@FindBy(css = "[class*='flyInOut']")
//	WebElement errorMessage;
	
	
@FindBy(css=".ng-tns-c4-5.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error")
WebElement errormsg;
	
	//.ng-tns-c4-5.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
	// flyInOut

	public ProductCateLogue loginApplication(String email, String pwd) {
		Emails.sendKeys(email);
		Passwords.sendKeys(pwd);
		LoginBtn.click();

		ProductCateLogue catelogue = new ProductCateLogue(driver);
		return catelogue;
	}

	public String getErrorMessage() {
		
		waitForWebElementToAppesr(errormsg);
		
		return errormsg.getText();
	}

	public void goTO() {
		driver.get("https://rahulshettyacademy.com/client");
	}

}
