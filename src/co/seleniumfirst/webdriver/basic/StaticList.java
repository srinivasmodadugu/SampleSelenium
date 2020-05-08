package co.seleniumfirst.webdriver.basic;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticList {
	public static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	
	driver.navigate().to("https://rahulshettyacademy.com/dropdownsPractise/");
	driver.manage().window().maximize();
	//String title = driver.getTitle();
	/*System.out.println(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"));
	driver.findElement(By.id("Div1")).click();
	System.out.println(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"));
		*/
	driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[@text='Amritsar (ATQ)']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//a[@text='Chennai (MAA)'])[2]")).click();;
	//driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']"));
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight']")).click();
	/*driver.findElement(By.id("divpaxinfo")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("hrefIncAdt")).click();*/
	/*driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']"));
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[contains(text(),'27')][1]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date2']"));
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[contains(text(),'29')])[2]")).click();
	Thread.sleep(2000);
	*/
	Select s= new Select(driver.findElement(By.cssSelector("#ctl00_mainContent_DropDownListCurrency")));
	s.selectByIndex(2);
	Thread.sleep(2000);
	s.selectByVisibleText("USD");
	driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();	
	Thread.sleep(5000);
	driver.close();
	driver.quit();
	
	}

}
