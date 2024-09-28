package qa.testceses;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrokenLinks {
	
	@Test
	
	
	public void BrokenLinkTes() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
List<WebElement>	links=driver.findElements(By.tagName("a"));

System.out.println(links.size());
for(WebElement e:links) {
	
	String url=e.getAttribute("href");
	//System.out.println(url);
	if(url==null || url.isEmpty()){
		System.out.println("URL is empy.");
		continue;
	}
		try {
		HttpURLConnection huc=	(HttpURLConnection) (new URL(url).openConnection());
			
			
			huc.connect();
			
			if(huc.getResponseCode()>=400) {
				System.out.println(url+"=== Broken Url");
			} else {
				System.out.println(url+"=== url is valid");
			}
			
			
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

driver.close();

	}

}
