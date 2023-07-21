package july4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FreeCRM {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://in.freecrm.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.findElement(By.xpath("//span[text()='Log In']")).click();
		driver.findElement(By.name("email")).sendKeys("rajalakshmi.laksh@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Srivatsan@143");
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		System.out.println(driver.getTitle());
		

	}

}
