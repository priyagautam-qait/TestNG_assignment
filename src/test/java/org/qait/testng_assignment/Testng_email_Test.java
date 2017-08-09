package org.qait.testng_assignment;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Testng_email_Test {

	
	
	@Test(dataProvider="getemail_subject_body")
	public void loginGmail(String email,String subject,String body) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "/home/priyagautam/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/gmail/about/#");
		driver.findElement(By.xpath("//a[text()='Sign In']")).click();
		driver.findElement(By.id("identifierId")).sendKeys("priya24573@gmail.com");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("input[name=\"password\"]")).sendKeys("gmail@gautam25");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[text()='COMPOSE']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("textarea[name=\"to\"]")).sendKeys(email);
		driver.findElement(By.cssSelector("input[name='subjectbox']")).sendKeys(subject);
		driver.findElement(By.xpath("//div[text()='Send']")).click();
		
		
		}
	@DataProvider(name = "getemail_subject_body", parallel = true)
	public Object[][] getdetails() throws IOException {
		ExcelReader obj = new ExcelReader();
		Object arr[][] = obj.getDetailsFromExcel();
		return arr;

	}
	
}
