package july4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//1) Go to  https://www.nykaa.com/
//2) Mouseover on Brands and Search L'Oreal Paris
//3) Click L'Oreal Paris
//4) Check the title contains L'Oreal Paris(Hint-GetTitle)
//5) Click sort By and select customer top rated
//6) Click Category and click Hair->Click haircare->Shampoo
//7) Click->Concern->Color Protection
//8)check whether the Filter is applied with Shampoo
//9) Click on L'Oreal Paris Colour Protect Shampoo
//10) GO to the new window and select size as 175ml
//11) Print the MRP of the product
//12) Click on ADD to BAG
//13) Go to Shopping Bag 
//14) Print the Grand Total amount
//15) Click Proceed
//16) Click on Continue as Guest
//17) Check if this grand total is the same in step 14
//18) Close all windows

public class NykaTestcase {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        option.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(option);
        driver.get("https://www.nykaa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        
        WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
        WebElement paris = driver.findElement(By.xpath("//a[contains(text(),'Oreal Paris')]"));
        Actions ab  =new Actions(driver);
        ab.moveToElement(brands).click(paris).perform();
        System.out.println(driver.getTitle());
        
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[@class='sort-name']")).click();
        driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
       
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Category']")));
        WebElement category = driver.findElement(By.xpath("//span[text()='Category']"));
        category.click();
        driver.findElement(By.xpath("//span[text()='Hair']")).click();
        driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
        driver.findElement(By.xpath("//span[text()='Concern']")).click();
        driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
        driver.findElement(By.xpath("//div[@class='css-xrzmfa']")).click();
        
        Set<String> handles = driver.getWindowHandles();
        List<String> list  =new ArrayList<String>(handles);
        
        driver.switchTo().window(list.get(1));
        System.out.println(driver.getTitle());
        
        driver.findElement(By.xpath("//span[@class=' css-d3w64v']")).click();
        String text = driver.findElement(By.xpath("//span[@class='css-1jczs19']")).getText();
        System.out.println(text);
        driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();
        driver.findElement(By.xpath("//button[@class='css-aesrxy']/*")).click();
        Thread.sleep(2000);
        driver.switchTo().frame(0);
        String text2 = driver.findElement(By.xpath("//div[@class='css-15py5ir e25lf6d2']/span")).getText();
        System.out.println("itemp price:"+text2);
        String price1 = text2.replaceAll("[^0-9]","");
        int num1= Integer.parseInt(price1);
      //  driver.switchTo().defaultContent();
        
        driver.findElement(By.xpath("//span[text()='Proceed']")).click();
        driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
        String text3 = driver.findElement(By.xpath("//p[@class='css-1e59vjt eka6zu20']")).getText();
        
        System.out.println("final price:"+text3);
        String price2 = text3.replaceAll("[^0-9]","");
        int num2 = Integer.parseInt(price2);
        if(num1== num2) {
        	
        	System.out.println("Its verified that price is equal");
        }else {
        	
        	System.out.println("Its verified that price is not equal");
        }
        
        
        driver.quit();
        

	}

}
