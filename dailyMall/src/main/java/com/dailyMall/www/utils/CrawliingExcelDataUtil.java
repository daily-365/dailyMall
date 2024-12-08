package com.dailyMall.www.utils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class CrawliingExcelDataUtil {
	
	
	public static void main(String[] args) throws Exception {

		WebDriver driver;
		WebElement element;
		
		 String WEB_DRIVER_ID="webdriver.chrome.driver";
		 String WEB_DRIVER_PATH="C:\\chromedriver-win64\\chromedriver.exe";
		
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
	
		//Runtime.getRuntime().exec("C:/Program Files/Google/Chrome/Application/chrome.exe --remote-debugging-port=9222 --user-data-dir=\"C:/Selenium/ChromeData\"");

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.addArguments("--disable-popup-blocking");
		chromeOptions.addArguments("--remote-allow-origins=*");
	
		chromeOptions.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
		
		driver = new ChromeDriver(chromeOptions);
	        
		
		String requestUrl ="https://www.nonghyupmall.com/BC13010R/exhDaeCtgrList.nh?cateNo=001&mediaD=0&chanC=1101&lctgrC=001&mctgrC=013&exhCfc=11&ctgrStp=2";
		
		try {
			
			driver.get(requestUrl);;
			Thread.sleep(2000);
		    element = driver.findElement(By.className("product-thumb-area"));
		    
		    System.out.println(element.getText());
		    
		    //element.click();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//driver.close();
		}
	
	}
	
}
