package july10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

/*1. Launch URL "http://leaftaps.com/opentaps/control/login"
* 
* 2. Enter UserName and Password Using Id Locator
* 
* 3. Click on Login Button using Class Locator
* 
* 4. Click on CRM/SFA Link
* 
* 5. Click on Accounts Button
* 
* 6. Click on Create Account
* 
* 7. Select preferred currency as Indian Rupee using SelectByValue
* 
* 8. Enter the Description text as "NRI Account"
* 
* 9. Enter LocalName Field Using Xpath Locator
* 
* 10. Enter SiteName Field Using Xpath Locator
* 
* 11. Enter value for AnnualRevenue Field using Xpath Locator but class as
 Attribute */

public class LeaftabCreateAccount {

	public static void main(String[] args) {
     ChromeOptions option = new ChromeOptions();
     option.addArguments("-remote-allow=origins=*");
     option.addArguments("--disable-notifications");
     ChromeDriver driver= new ChromeDriver();
     driver.get("http://leaftaps.com/opentaps/control/login");
     
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
     
     driver.findElement(By.id("username")).sendKeys("demosalesmanager");
     driver.findElement(By.id("password")).sendKeys("crmsfa");
     
     driver.findElement(By.className("decorativeSubmit")).click();
     driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
     driver.findElement(By.xpath("//a[text()='Accounts']")).click();
     driver.findElement(By.xpath("//a[text()='Create Account']")).click();
     WebElement element = driver.findElement(By.id("currencyUomId"));
     Select sd = new Select(element);
		sd.selectByValue("INR");
		driver.findElement(By.name("description")).sendKeys("NRI account");
		driver.findElement(By.xpath("//input[@name='groupNameLocal']")).sendKeys("john");
		driver.findElement(By.xpath("//input[@name='officeSiteName']")).sendKeys("Chennaione");
		driver.findElement(By.xpath("(//input[@class='inputBox'])[5]")).sendKeys("2C");
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		WebElement element2 = driver.findElement(By.xpath("//li[@class='errorMessage']"));
		System.out.println(element2.getText());
		driver.close();


	}

}
