package helwan.training.demos.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemosTests {

	@Test
	public void demo1(){
		
		
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com");
		String title = driver.getTitle();  //get the title
		System.out.println(title);
		WebElement englishHyperLink= driver.findElement(By.linkText("English"));
		englishHyperLink.click();  //Click on the hyperlink
		WebElement textbox = driver.findElement(By.id("lst-ib"));
		textbox.sendKeys("itworx");  // enter itworx in the text box
		driver.close();  //close the driver
		
		
		
		
		
		
		
		
		
		
	}
	
}
