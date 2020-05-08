package co.seleniumfirst.webdriver.basic;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountDynamicLinksDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// System.out.println(driver.findElements(By.tagName("a")).size());

		WebElement columndriver = driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		String clickontab = Keys.chord(Keys.CONTROL, Keys.ENTER);

		int links = columndriver.findElements(By.tagName("a")).size();
		for (int i = 0; i < links; i++) {
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickontab);
			;
		}
		Set<String> abc = driver.getWindowHandles();
		Iterator<String> it = abc.iterator();
		Thread.sleep(2000);
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
	
	}

}
