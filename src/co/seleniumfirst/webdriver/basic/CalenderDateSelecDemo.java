package co.seleniumfirst.webdriver.basic;

import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderDateSelecDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", ".//driver//chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		//April 23
		driver.findElementByXPath(".//*[@id='travel_date']").click();
		
	}

}
