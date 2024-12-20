package tests;

import java.time.Duration
;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utill.BaseTest;

public class DisablePasswordManageFeatures extends BaseTest{
	

	@Test(priority=1)
	public void navigateToOpenCart() throws InterruptedException {
		
		driver.get("https://naveenautomationlabs.com/opencart/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//ul[contains(@class,'dropdown-menu-right')]//a[text()='Login']"))).click().build().perform();
		Thread.sleep(100);
		
		
	}
	@Test(priority=2)
	public void loginToOpenCart() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		navigateToOpenCart();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("test112@gmail.com");
		driver.findElement(By.cssSelector("#input-password")).sendKeys("Test@123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		softAssert.assertFalse(driver.findElement(By.xpath("//img[@title='naveenopencart']")).isDisplayed());
		softAssert.assertTrue(driver.getPageSource().contains("My Account"),"The page does not contains My Account");
		softAssert.assertAll();
		Thread.sleep(5000);

		
	}
	@Test
	public void verifyMenuItems() {
		Assert.assertTrue(true);
	
	}
	


}
