package qa.testceses;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Mahadeva.ZFramework.pageobjects.CartPage;
import Mahadeva.ZFramework.pageobjects.CheckOutPage;
import Mahadeva.ZFramework.pageobjects.ConfirmationPage;
import Mahadeva.ZFramework.pageobjects.ProductCateLogue;
import qa.testComponents.BaseTest;
import qa.testComponents.Retry;

public class ErrorValidation extends BaseTest{
	
	@Test (groups = {"ErrorHandling"},retryAnalyzer =Retry.class )
	public void LoginerrorMessage() throws IOException  {
		String productName = "ZARA COAT 3";
		landingPage.loginApplication("mahanteshsb460@gmail.com", "@Power1234");
		
	Assert.assertEquals("Incorrect email or password. ", landingPage.getErrorMessage());
	
	System.out.println("Har Har Mahadeva");
}
	@Test
	public void ErrosubmitOrderTest() throws IOException  {
		String productName = "ZARA COAT 3";
		
		
		ProductCateLogue catelogue=	landingPage.loginApplication("mahanteshsb460@gmail.com", "@Power123");
		
		List<WebElement>products=catelogue.getProductList();
		catelogue.adProductToCardr(productName);
	CartPage	cartpage=catelogue.goToCartPage();
		
	Boolean match=cartpage.verifyProductDisplay(productName);
//	Assert.assertTrue(match);
	Assert.assertTrue(match);
	
	
	System.out.println("Har Har Mahadeva");
}
}
