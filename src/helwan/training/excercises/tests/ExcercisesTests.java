package helwan.training.excercises.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcercisesTests {

	@Test
	public void excercise_1() {
		
		System.setProperty("webdriver.chrome.driver", "./ChromeDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.store.demoqa.com");
		String pageTitle = driver.getTitle();   //get the title 
		String pageUrl = driver.getCurrentUrl(); //get the currect url
		boolean isUrlCorrect = false;
		if(pageUrl.equals("http://store.demoqa.com/")){
			isUrlCorrect = true;
			Assert.assertTrue("The url is not correct", isUrlCorrect);	
		}
		
		int pageSourceLength = driver.getPageSource().length(); //get page source length
		System.out.println(pageTitle);
		System.out.println(pageUrl);
		System.out.println(pageSourceLength);
		
		Assert.assertNotNull("The page title is not correct", pageTitle);
		Assert.assertNotEquals("The page source is not correct", 0, pageSourceLength);
		driver.navigate().refresh(); //refresh the page
		driver.close();  //close the driver
	}
}
