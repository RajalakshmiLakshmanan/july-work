package july4;
//1.Load the URL https://www.amazon.in/
//2.search as oneplus 9 pro 
//3.Get the price of the first product
//4. Print the number of customer ratings for the first displayed product
//5. Click the first text link of the first image
//6. Take a screen shot of the product displayed
//7. Click 'Add to Cart' button
//8. Get the cart subtotal and verify if it is correct.
//9.close the browser


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchBrowser {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions ();
		option.addArguments("--remote=allow-origins=*");
		ChromeDriver driver= new ChromeDriver(option);
		
		driver.get("https://www.amazon.in");
	}

}
