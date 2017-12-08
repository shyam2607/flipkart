package ecommerce;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class  products 
{
	public static WebDriver driver;
	String url= "https://www.flipkart.com/";
	@BeforeTest
	 	public void setup() throws InterruptedException
     { 
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\Mathivathani\\Desktop\\drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get(url);
		 driver.findElement(By.className("_2zrpKA")).sendKeys("varunvishal28@gmail.com");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")).sendKeys("Tour2810");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button")).click();
	 }
	@Test(priority=1)
		public void category() throws InterruptedException 
	{
		
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		WebElement men=driver.findElement(By.xpath(".//*[@id='container']/div/header/div[2]/div/ul/li[3]/a/span"));
		WebElement tshirt=driver.findElement(By.xpath(".//*[@id='container']/div/header/div[2]/div/ul/li[3]/ul/li/ul/li[2]/ul/li[2]/a/span"));
		action.moveToElement(men).build().perform();
		Thread.sleep(5000);
		action.moveToElement(men).click(tshirt).build().perform();
		Thread.sleep(3000);
	}
	@Test(priority=2)
		public void product() throws InterruptedException
		{
			Thread.sleep(3000);
			driver.findElement(By.xpath(".//*[@id='container']/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[1]/div[1]/div[3]/div/a[1]/div/div/div[1]/img")).click();
			//driver.findElement(By.xpath(".//*[@id='container']/div/div[1]/div/div/div/div[1]/div/div[1]/div[2]/ul/li/button")).click();
			String parent=driver.getWindowHandle();
			 // This will return the number of windows opened by Webdriver and will return Set of Strings
			Set <String> s1=driver.getWindowHandles();
			 // Now we will iterate using Iterator
			Iterator <String> I1= s1.iterator();
			while(I1.hasNext())
			{
			 String child_window=I1.next();
			 // Here we will compare if parent window is not equal to child window 
			 if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			 System.out.println(driver.switchTo().window(child_window).getTitle());
			 driver.findElement(By.xpath(".//*[@id='swatch-1-size']/a")).click();
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div[1]/div/div[1]/div[2]/ul/li/button")).click();
			 Thread.sleep(2000);
			}
			
		}
			Actions action = new Actions(driver);
			WebElement logmenu = driver.findElement(By.xpath(".//*[@id='container']/div/header/div/div[1]/div/ul/li/a"));
			WebElement logout = driver.findElement(By.xpath(".//*[@id='container']/div/header/div/div[1]/div/ul/li/ul/li[8]/a"));
			action.moveToElement(logmenu).build().perform();
			Thread.sleep(5000);
			action.moveToElement(logmenu).click(logout).build().perform();
			Thread.sleep(3000);
	
		}
}
