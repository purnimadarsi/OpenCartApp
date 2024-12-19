package utill;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
    protected  WebDriver driver;

    @BeforeMethod
    public void setUp() {
    	try {
    	System.out.println("enteredddddddd");
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--remote-debugging-port=9222");
    	options.addArguments("--remote-allow-origins=*");


    	Map<String,Object> prefs= new HashMap<>();
    	prefs.put("credentials_enable_service", false);
    	prefs.put("profile.password_manager_enabled", false);
    	prefs.put("profile.password_manager_leak_detection", false);
    	options.setExperimentalOption("prefs",prefs);
    	
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	}
    	catch(Exception e) {
    		System.err.println("error during webdriver setup" +e.getMessage());
    		e.printStackTrace();
    	}
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
