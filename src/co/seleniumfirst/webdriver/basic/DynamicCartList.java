package co.seleniumfirst.webdriver.basic;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicCartList {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		String[] list = { "Brocolli", "Carrot", "Beans" };
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		addItems(driver, list);
		placeOrder(driver);
		driver.close();
		driver.quit();
	}

	public static void addItems(WebDriver driver, String[] itemsNeeded) {
		int j = 0;
		List<WebElement> productName = driver.findElements(By.cssSelector("h4.product-name"));
		List itemsNeededList = Arrays.asList(itemsNeeded);
		for (int i = 0; i < productName.size(); i++) {
			String[] name = productName.get(i).getText().split("-");
			// Brocolli - 1 Kg
			String item = name[0].trim();
			if (itemsNeededList.contains(item)) {
				j++;
				// driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
			}
			if (j == itemsNeededList.size())
				break;
		}
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
	}
	public static void placeOrder(WebDriver driver)
	{
		driver.findElement(By.cssSelector("input.promocode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
	WebDriverWait w=new WebDriverWait(driver,5);
	w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoinfo")));
	System.out.println(driver.findElement(By.cssSelector("span.promoinfo")).getText());
	}
	
	// driver.close();
	
	// driver.quit();
}
