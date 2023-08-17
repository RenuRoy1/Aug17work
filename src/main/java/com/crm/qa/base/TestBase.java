package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;



public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
public static void initilaization() {
	String browserName= prop.getProperty("browser");
	
	if(browserName.equals("chrome")) {
		//WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		
	}
	
	else if (browserName.equals("firefox")) {
		//WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();
			
	}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.implicit_wait));
	driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(40));
	
	driver.get(prop.getProperty("url"));
	
}
}
