package helwan.training.excercises.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExcercisesTests {

	WebDriver driver;
	
	@Before
	public void setup(){
	
		System.setProperty("webdriver.chrome.driver", "./ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@Test
	public void excercise_1() {
		
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
		 
	}
	
	@Test
	public void selectExcerise(){
			
			driver.get("http://toolsqa.com/automation-practice-form/");
			Select select=new Select(driver.findElement(By.id("selenium_commands")));
			select.selectByVisibleText("Browser Commands");
			select.deselectByIndex(0);
			
			for(WebElement option:select.getOptions()){
				
				System.out.println(option.getText());
				option.click();
			}
			
			select.deselectAll();
		}
	
	@Test
	public void waitExcercise(){
		
		driver.get("http://google.com");
		driver.findElement(By.id("lst-ib")).sendKeys("itworx");
		driver.findElement(By.name("btnK")).click();
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"hdtb-msb\"]/div[1]/div[2]/a")));
		driver.findElement(By.xpath("//*[@id=\"hdtb-msb\"]/div[1]/div[2]/a")).click();
		
	}
	
	
	@After
	public void tearDown(){
		driver.close();
	}
	
	}

