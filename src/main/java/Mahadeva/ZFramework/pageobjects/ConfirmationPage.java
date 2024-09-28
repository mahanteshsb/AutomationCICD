package Mahadeva.ZFramework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.page.abstractcomponents.AbstractComponents;

public class ConfirmationPage extends AbstractComponents {

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(css=".hero-primary")
	WebElement confirmMessage;
	
	

	public String getConfirmationMessage() {
		return confirmMessage.getText();
	}
}
