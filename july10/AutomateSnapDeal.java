package july10;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

//1. Launch https://www.snapdeal.com/
//2. Go to Mens Fashion
//3. Go to Sports Shoes
//4. Get the count of the sports shoes
//5. Click Training shoes
//6. Sort by Low to High
//7. Check if the items displayed are sorted correctly
//8.Select the price range (900-1200)
//9.Filter with color Navy 
//10 verify the all applied filters 
//11. Mouse Hover on first resulting Training shoes
//12. click QuickView button
//13. Print the cost and the discount percentage
//14. Take the snapshot of the shoes.
//15. Close the current window
//16. Close the main window


public class AutomateSnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		WebElement men = driver.findElement(By.xpath("//span[contains(text(),'Men')]"));
		WebElement shoes = driver.findElement(By.xpath("//span[text()='Sports Shoes']"));
		Actions ad= new Actions(driver);
		ad.moveToElement(men).click(shoes).perform();
		String text = driver.findElement(By.xpath("//div[@class='child-cat-count ']")).getText();
		System.out.println(text);
		
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		driver.findElement(By.xpath("(//ul[@class='sort-value']/li)[2]")).click();
		Thread.sleep(2000);
		List<WebElement> list = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		
		for(WebElement price:list) {
         String text2 = price.getText();
         System.out.print(text2+",");
			
		}
		WebElement drag = driver.findElement(By.xpath("//a[contains(@class,'price-slider-scroll left-handle')]"));
		Actions dg= new Actions(driver);
	
		Point location = drag.getLocation();
		System.out.println(location);
		
		dg.dragAndDropBy(drag, 0, 3).perform();
		Thread.sleep(1000);
		
		WebElement drop = driver.findElement(By.xpath("//a[contains(@class,'price-slider-scroll right-handle')]"));
		Actions dp= new Actions(driver);
		dp.dragAndDropBy(drop,-50, 0).perform();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
		List<WebElement> filter = driver.findElements(By.xpath("//div[@class='navFiltersPill']"));
		for(WebElement fil:filter) {
			String text2 = fil.getText();
			System.out.println(text2);
			
		}
		Thread.sleep(2000);
		WebElement img = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
		WebElement view = driver.findElement(By.xpath("//div[contains(text(),'Quick View')]"));
		Actions mg = new Actions(driver);
		mg.moveToElement(img).click(view).perform();
		Thread.sleep(2000);
		File file = driver.getScreenshotAs(OutputType.FILE);
		File des= new File("./snap/shoe.png");
		FileUtils.copyFile(file, des);
		
		
		String text2 = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		System.out.println("price:"+text2);
		driver.quit();
	}

}
