package tests;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test_utils.Helper;

public class PostFreeAd extends Helper {
	
	@BeforeMethod
	public void before() {
		browserType();
		loadPage();
	}
	
	//To post a free ad on Quikr.com for selling a bicycle
	
	@Test
	public void postAd() {
		
		driver.findElement(By.cssSelector(or.getProperty("clickPostAd_css"))).click();
		System.out.println(driver.getCurrentUrl());
		sleep(5);
		
		//Mouse over on the category
		Actions a =new Actions(driver);
		a.moveToElement(driver.findElement(By.className(or.getProperty("mouseOverCarIcon_class")))).build().perform();	    
		sleep(2);
		
		//selecting sub category
		driver.findElement(By.linkText(or.getProperty("clickBicycleSubLink_linkText"))).click();
		
		log.debug(driver.findElement(By.name(or.getProperty("adTypeRadio_name"))).getAttribute("value"));
			
		//Entering required fields like title, description, price, condition,
		//city, area, contact details, etc.
		driver.findElement(By.name(or.getProperty("adTypeRadio_name"))).click();
		
		driver.findElement(By.id(or.getProperty("titleInput_id"))).sendKeys(config.getProperty("titleForAd"));
		
		driver.findElement(By.name(or.getProperty("conditionRadio_name"))).click();
	    
	    driver.findElement(By.id(or.getProperty("priceInput_id"))).sendKeys(config.getProperty("price"));
	    
	    driver.findElement(By.id(or.getProperty("areaSelectDropDown_id"))).click();
	    
	    sleep(5);
	    
	    List <WebElement> areaList = driver.findElement(By.id(or.getProperty("areaListContainer_id"))).findElements(By.cssSelector(or.getProperty("areanameslist_css")));
	    
	    System.out.println(areaList.size());
	    
	    Random randomArea = new Random();
		int city = randomArea.nextInt(areaList.size()-1);
		areaList.get(city).click();
	    
	    driver.findElement(By.id(or.getProperty("descriptionTextBox_id"))).sendKeys(config.getProperty("description"));
	    
	    driver.findElement(By.name(or.getProperty("sellerTypeYouAre_name"))).click();

	    driver.findElement(By.id(or.getProperty("contactName_id"))).sendKeys(config.getProperty("contactName"));
	   
	    driver.findElement(By.id(or.getProperty("email_id"))).sendKeys(config.getProperty("email"));
	    
	    driver.findElement(By.id(or.getProperty("mobile_id"))).sendKeys("");
	    
	    driver.findElement(By.className(or.getProperty("postButton_class"))).click();
		
	}
	
	
	@AfterMethod
	public void after() {
		//closingBrowser();
	}
}
