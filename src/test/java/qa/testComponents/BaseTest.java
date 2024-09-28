package qa.testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Mahadeva.ZFramework.pageobjects.LandingPage;

public class BaseTest {

	public WebDriver driver;
	public LandingPage landingPage;
	public WebDriver initializeDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//qa//resources//GlobalData.properties");
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {

		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "edge.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	
	public  List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		//readjson to string
	String jsonContent=	FileUtils.readFileToString(new File(filePath),
			StandardCharsets.UTF_8);
		//String to HashMap
	//Jackson Datanind
	ObjectMapper mapper=new ObjectMapper();
	
	
	List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>> () {
	});
		//{map,map1}	
		
		return data;
	}
	

	public String getScreenshot(String testCaseName , WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir"+"//reports//"+testCaseName+".png"));
		
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir"+"//reports//"+testCaseName+".png");
	}

	@BeforeMethod(alwaysRun =true)
	public LandingPage launchApplication() throws IOException {
		driver = initializeDriver();
		 landingPage = new LandingPage(driver);
		landingPage.goTO();
		
		return landingPage;

	}
	
	@AfterMethod(alwaysRun =true)
	public void tearDown() {
		driver.close();
	}

}
