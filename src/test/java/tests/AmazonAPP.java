package tests;

import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonAPP {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");

	}
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
//	@Test
//	public void navigateToAmazonWebPage() {
//	}
	@Test
	public void DisplayAllAdds() {
		
		//ol//li[contains(@style,'visible')]//img
		//i[contains(@class,'a-icon a-icon-next-rounded')]
		Set<String> uniqueImages = new HashSet<>();
		boolean started = true;
		while(started) {
			String imageUrl= driver.findElement(By.xpath("//ol//li[contains(@style,'visible')]//img")).getAttribute("src");
			driver.findElement(By.xpath("//i[contains(@class,'a-icon a-icon-next-rounded')]")).click();
			if(uniqueImages.contains(uniqueImages)) {
				started = false;
			}
			else {
				uniqueImages.add(imageUrl);
			}
		}
		System.out.println(uniqueImages);
		System.out.println(uniqueImages.size());

		
		
	}

}
