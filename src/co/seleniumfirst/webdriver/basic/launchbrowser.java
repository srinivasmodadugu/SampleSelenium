package co.seleniumfirst.webdriver.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class launchbrowser {
	public static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	
	driver.navigate().to("https://amazon.in");
	driver.manage().window().maximize();
	String title = driver.getTitle();
	if (title.equalsIgnoreCase("Amazon.in"))
		System.out.println("Title matches");
	else 
		System.out.println(title);
	WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
	searchBox.sendKeys("Mobile");
//	driver.findElement(By.className("nav-input")).click();
//	driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[1]")).click();
	String catText="";
	catText=driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(2)")).getText();
	System.out.println(catText);
	driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(2)")).click();
	Thread.sleep(5000);
	driver.close();
	driver.quit();
	
	}

}
