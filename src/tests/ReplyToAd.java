package tests;

import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.asprise.util.ocr.OCR;

import test_utils.Helper;

public class ReplyToAd extends Helper {
	
	@BeforeMethod
	public void before() {
		browserType();
		loadPage();
	}
	
	
	//Giving reply to an already posted ad
	
	@Test
	public void replyToAd() throws IOException {
		
		System.out.println(driver.getCurrentUrl());
		
		
		driver.findElement(By.id(or.getProperty("searchTextBox_id"))).sendKeys(config.getProperty("item"));
		driver.findElement(By.cssSelector(or.getProperty("searchButton_css"))).click();
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.id(or.getProperty("adContainer_id"))).findElement(By.id(or.getProperty("adReplyButton_id"))).click();
		
		driver.findElement(By.id(or.getProperty("replyContentTextField_id"))).sendKeys(config.getProperty("replyContent"));
		driver.findElement(By.id(or.getProperty("emailTextBox_id"))).sendKeys(config.getProperty("replyEmail"));
		String checkbox = driver.findElement(By.id("reply_alert")).getAttribute("checked");
		System.out.println(checkbox);
		driver.findElement(By.id(or.getProperty("alertCheckBox_id"))).click();
		String checkbox1 = driver.findElement(By.id(or.getProperty("alertCheckBox_id"))).getAttribute("checked");
		System.out.println(checkbox1);
		
		if(checkbox.contains("checked")) {
			driver.findElement(By.id(or.getProperty("alertCheckBox_id"))).click();
		}
		
		
		/* String imageUrl = driver.findElement(By.id("cap_holder")).findElement(By.tagName("img")).getAttribute("src");
	     System.out.println(imageUrl);
	     URL url = new URL(imageUrl);
	     Image img = ImageIO.read(url);
	     String s = new OCR().recognizeCharacters((RenderedImage) img);
	     System.out.println(s+ " "+s.length());
	     driver.findElement(By.id("captinp")).sendKeys(s); */
		
		driver.findElement(By.className(or.getProperty("postReplyButton_id"))).click();
		//sleep(10);
		//String reply = driver.findElement(By.id("ad182027343")).findElement(By.id("reply_wrapper")).findElement(By.cssSelector("div.downthxmsg")).getText();
		//System.out.println(reply);
		
		
	}
	
	
	@AfterMethod
	public void after() {
		//closingBrowser();
	}
}
