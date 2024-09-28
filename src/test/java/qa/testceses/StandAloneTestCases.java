package qa.testceses;

import java.io.File;
import java.io.IOException;

import java.time.Duration;
import java.util.List;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Mahadeva.ZFramework.pageobjects.CartPage;
import Mahadeva.ZFramework.pageobjects.CheckOutPage;
import Mahadeva.ZFramework.pageobjects.ConfirmationPage;
import Mahadeva.ZFramework.pageobjects.LandingPage;
import Mahadeva.ZFramework.pageobjects.ProductCateLogue;
import io.github.bonigarcia.wdm.WebDriverManager;
import qa.testComponents.BaseTest;

public class StandAloneTestCases extends BaseTest{
	public WebDriver driver;
	@Test (dataProvider = "getData",groups = "Purchage order")
	public void submitIrder(HashMap<String , String> Input) throws IOException  {
		String productName = "ZARA COAT 3";
		
		
		ProductCateLogue catelogue=	landingPage.loginApplication(Input.get("email"), Input.get("password"));
		
		List<WebElement>products=catelogue.getProductList();
		catelogue.adProductToCardr(Input.get("ProductName"));
	CartPage	cartpage=catelogue.goToCartPage();
		
	Boolean match=cartpage.verifyProductDisplay(Input.get("ProductName"));
	Assert.assertTrue(match);
	
	CheckOutPage checkoutpage=cartpage.checckOutPage();
	checkoutpage.SelectCountry("India");
	ConfirmationPage confirmationPage=checkoutpage.submitOrder();
	String confirmMessage=confirmationPage.getConfirmationMessage();
	Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	
	System.out.println("Har Har Mahadeva");
}
	//To verify ZAr COAt 3is displaying in orders page
	
	@Test(dependsOnMethods = {"submitIrder"})
	public void orderHistoryTest() {
		//"ZARA CoAT 3
	}
	
	//Extent Report
	
	
	
	/*
	@DataProvider
	public Object[][] getData() {
		
		HashMap<String , String> map=new HashMap<String, String> ();
		
		map.put("email", "mahanteshsb460@gmail.com");
		map.put("password", "@Power123");
		map.put("ProductName", "ZARA COAT 3");
		
HashMap<String , String> map1=new HashMap<String, String> ();
		
		map1.put("email", "mahanteshsb461@gmail.com");
		map1.put("password", "@Power123");
		map1.put("ProductName", "ADIDAS ORIGINAL");
		
	return	new Object[][] {{map},{map1}};
	
	}
	
	*/
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		List<HashMap<String,String>> data=getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\qa\\testcases\\data\\PurchageOrder.json");		
	return	new Object[][] {{data.get(0)},{data.get(1)}};
	
	}
	
}
