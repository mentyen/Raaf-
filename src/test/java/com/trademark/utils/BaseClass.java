package com.trademark.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.trademark.pages.HomePage;

public class BaseClass {
	
	public static ExtentHtmlReporter htmlReport;
	public static ExtentReports report;
	public static ExtentTest test;
	public static WebDriver driver; 	
	
	
	@BeforeMethod(alwaysRun=true)
	public void setUp() {
		
		   String browserName = ConfigsReader.getProperty("browser");
	        if (browserName.equalsIgnoreCase("chrome")) {
	            if (Constants.OS_NAME.contains("Mac")) {
	                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
	            } else if (Constants.OS_NAME.contains("Windows")) {
	                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
	            } else if (Constants.OS_NAME.contains("Linux")) {
	                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
	                }
	            driver = new ChromeDriver();
	            //options=new ChromeOptions();
	            // options.addArguments("--headless", "--disale-gpu");
	             //driver = new ChromeDriver(options);
	        } else if (browserName.equalsIgnoreCase("firefox")) {
	            if (Constants.OS_NAME.contains("Mac")) {
	                System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
	            } else if (Constants.OS_NAME.contains("Windows")) {
	                System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
	            } else if (Constants.OS_NAME.contains("Linux")) {
	                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
	                }
	            driver = new FirefoxDriver();
	            //options=new ChromeOptions();
	            // options.addArguments("--headless", "--disale-gpu");
	             //driver = new ChromeDriver(options);
	        } else if (browserName.equalsIgnoreCase("ie")) {
	            System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/IEDriverServer");
	            driver = new InternetExplorerDriver();
	            //options=new ChromeOptions();
	            // options.addArguments("--headless", "--disale-gpu");
	             //driver = new ChromeDriver(options);
	        } else {
	            System.out.println("browser given is wrong");
	        }
	        driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        driver.manage().window().fullscreen();
	        driver.get(ConfigsReader.getProperty("url"));
	    		
		
	}
	
	
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		
		driver.quit();
		//options=new ChromeOptions();
        // options.addArguments("--headless", "--disale-gpu");
         //driver = new ChromeDriver(options);
		
	}
	
	
	@BeforeTest(alwaysRun=true)
	public void generateReport() {
		ConfigsReader.getProperty(Constants.EXCELL_PATH);
		//create an object of extentReport and htmlReporter
		htmlReport=new ExtentHtmlReporter(Constants.REPORT_FILEPATH);
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		//provide some info (optional)
		report.setSystemInfo("OS", Constants.OS_NAME);
		report.setSystemInfo("Environment", "Test");
		report.setSystemInfo("Browser", ConfigsReader.getProperty("browser"));
		report.setSystemInfo("QA Engineer", Constants.USER_NAME);
	}
	
	@AfterTest (alwaysRun = true)
	public void flushReport() {
		report.flush();
	}
	

}
