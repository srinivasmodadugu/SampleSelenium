package co.seleniumfirst.webdriver.basic;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowHandle {
	public static void main(String[] args) throws InterruptedException {
		
	System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://accounts.google.com/signup");
	System.out.println(driver.getTitle());
	driver.findElement(By.linkText("Help")).click();
	Set<String> ids=driver.getWindowHandles();
	Iterator<String> it=ids.iterator();
	String parentId=it.next();
	String child=it.next();
	driver.switchTo().window(child);
	System.out.println(driver.getTitle());
	driver.switchTo().window(parentId);
	System.out.println(driver.getTitle());
	driver.quit();
	
	}

}
