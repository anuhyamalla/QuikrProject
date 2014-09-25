package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test_utils.Helper;

public class DateSorting extends Helper{
	
	@BeforeMethod
	public void before() {
		browserType();
		loadPage();
	}
	
	//Searches for an Item in the search box and a list will be appeared in a list. Now these items in the list are sorted by date
	//The titles of the every ad in the container and the respective dates are printed
	@Test
	public void searchDateSort() {
		driver.findElement(By.id(or.getProperty("searchTextBox_id"))).sendKeys(config.getProperty("searchItem"));
		driver.findElement(By.cssSelector(or.getProperty("searchButton_css"))).click();
		driver.findElement(By.id(or.getProperty("resultContainer_id"))).findElement(By.linkText(or.getProperty("dateButton_linkText"))).click();
		
		List <WebElement> container_date = driver.findElement(By.id(or.getProperty("mainContainer_id"))).findElements(By.cssSelector(or.getProperty("dateInContainer_css")));
		List <WebElement> container_title = driver.findElement(By.id(or.getProperty("mainContainer_id"))).findElements(By.cssSelector(or.getProperty("titleInContainer_css")));
		
		System.out.println(container_date.size());
		for(int i = 0; i < container_date.size(); i++) {
			log.debug(container_title.get(i).getAttribute("title") + "	" + container_date.get(i).getText());
			Reporter.log(container_title.get(i).getAttribute("title") + "  " + container_date.get(i).getText());
		}
		
	}
	
	
	@AfterMethod
	public void after() {
		//closingBrowser();
	}
 

	
}
