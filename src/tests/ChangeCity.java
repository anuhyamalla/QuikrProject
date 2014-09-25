package tests;


import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test_utils.Helper;

public class ChangeCity extends Helper {
	
	@BeforeMethod
	public void before() {
		browserType();
		loadPage();
	}
	
	
	//Change city randomly using the Dropdown list elements
	//Will select any of the city in the list of cities displayed
	@Test
	public void changeCityRandom() {
		
		driver.findElement(By.className(or.getProperty("selectCityDropDown_class"))).click();
		sleep(5);
		List <WebElement> cityList = driver.findElement(By.cssSelector(or.getProperty("cityList_css"))).findElements(By.cssSelector(or.getProperty("cities_css")));
		System.out.println(cityList.size());
		Random randomCity = new Random();
		int city = randomCity.nextInt(cityList.size()-1);
		cityList.get(city).click();
		String city1 = driver.getCurrentUrl();
		String[] abc = city1.split("/");
		String[] pqr = abc[2].split(".quikr.com");
		log.debug("The City Selected is:" + pqr[0]);
		Reporter.log("The City Selected is:" + pqr[0]);
		sleep(10);
	} 
	
	
	//Change City by giving a City name in Text Box
	//Will give the data Bangalore in the text box and it'll select the city Bangalore 
	@Test
	public void changeCityTextBox() {
		
		driver.findElement(By.className(or.getProperty("selectCityDropDown_class"))).click();
		sleep(5);
		driver.findElement(By.className(or.getProperty("textBoxClick_class"))).click();
		driver.findElement(By.id(or.getProperty("textBoxSendKeys_id"))).sendKeys(config.getProperty("city"));
		sleep(5);
		driver.findElement(By.linkText(or.getProperty("textBoxSuggList_linkText"))).click();
		String city = driver.getCurrentUrl();
		String[] abc = city.split("/");
		String[] pqr = abc[2].split(".quikr.com");
		log.debug("The City Selected is:" + pqr[0]);
		Reporter.log("The City Selected is:" + pqr[0]);
		sleep(10);
	}
		
	
	
	@AfterMethod
	public void after() {
		closingBrowser();
	}
}
