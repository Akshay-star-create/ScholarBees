package com.qa.testbase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() throws IOException {
		prop = new Properties();
		FileInputStream ip;

		ip = new FileInputStream("/home/talentelgia/eclipse-workspace/ScholarBees/src/main/java/com/qa/config/config.properties");
		prop.load(ip);
	}

	
	public static void initialize() {
		String browserName = prop.getProperty("browser");

		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/home/talentelgia/downloads/chromedriver_linux64.exe");		

		}

		else if(browserName.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver", "/home/talentelgia/downloads/geckodriver-v0.26.0-linux64.exe");

		}

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get("https://scholarbees.teamtalentelgia.com/login");
		//driver.get(prop.getProperty("url"));

	}
	

	

	}





