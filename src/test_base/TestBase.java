package test_base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;



public class TestBase {
	
	public static Properties config = null;
	public static Properties or = null;
	
	public static WebDriver driver;
	
	public static Logger log = Logger.getLogger("devpinoyLogger");
	
	FileInputStream fp;
	FileInputStream fp1;
	
	
	

	
	@BeforeSuite
	public void initialize() throws IOException {
		
		fp= new FileInputStream(System.getProperty("user.dir") + "\\src\\config\\config.properties");
		config = new Properties();
		config.load(fp);
		fp1= new FileInputStream(System.getProperty("user.dir") + "\\src\\config\\or.properties");
		or = new Properties();
		or.load(fp1);
		
	}
	
	
}
