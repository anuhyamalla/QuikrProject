package tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test_utils.Helper;

public class SharedLinks extends Helper {
	

	@BeforeMethod
	public void before() {
		browserType();
	}
	
 
	//Clicking on the Shared links of the Social media like twitter, facebook, google+, youtube and 
	//verify whether the correct page is loaded or not
	@Test
	public void clickSharedLink() { 
		
		loadPage();
		
		List <WebElement> container = driver.findElement(By.className(or.getProperty("linksContainer_class"))).findElements(By.tagName(or.getProperty("links_tag")));
		
		
		if(container.size() == 0) {
				Assert.fail("Test Case SHAREDLINKS Failed: Social Media Links Not Found.");
		} else { 
			int j=0;
			for(int i = container.size()-1 ; i >= 0 ; i--) {
				
				String href = container.get(i).getAttribute("href");
				container.get(i).click();
				
				ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
				j++;
				driver.switchTo().window(tabs.get(j));   
				sleep(5);
				String url = driver.getCurrentUrl();
				String[] urlSite = url.split("/");
				String urlSplit = urlSite[2];
				log.debug(urlSite[2]);
				
				if(href.contains(urlSplit)) {	
					log.debug("Page navigated to: " + urlSplit );
					driver.switchTo().window(tabs.get(0));
				} else {
					Assert.fail("Wrong Page Loaded");
				}
			}
		}
		sleep(10);
	}
	
	
	
	@AfterMethod
	public void after() {
		closingBrowser();
	}
}
