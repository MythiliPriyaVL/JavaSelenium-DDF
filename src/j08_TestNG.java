import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class j08_TestNG {
	String bUrl = "https://qaonair.com/";
	String chromeDriver = "C:\\Users\\Mythili\\Software\\chromedriver.exe";	
	String vTerm, vSearchResult, myResult;	
	WebDriver myD;
	
	@BeforeSuite
	public static void beforeSuite() {
		System.out.println("BeforeSuite");
	}
	
	@BeforeTest
	public static void beforeTest() {
		System.out.println("BeforeTest");
	}
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("BeforeClass");
	}
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		System.out.println("BeforeMethod - Starting TC Execution");						
		System.setProperty("webdriver.chrome.driver",chromeDriver);
		myD = new ChromeDriver();
		myD.navigate().to(bUrl);		
		Thread.sleep(1000);
	}
	
	//@Test
	@Ignore
	public void TC01() throws InterruptedException {
		System.out.println("TestCase01 Execution");
		vTerm = "selenium";
		vSearchResult = "1150 profiles available";
		//Click on see all freelancers
		myD.findElement(By.linkText("See all freelancers")).click();
		myD.findElement(By.id("s")).sendKeys(vTerm);
		myD.findElement(By.id("s")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		//Get results
		myResult = myD.findElement(By.className("plural")).getText();
		System.out.println(myResult);
		if(myResult.equals(vSearchResult)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
		
	}
	
	//@Test
	@Ignore
	public void TC02() throws InterruptedException {
		System.out.println("TestCase02 Execution");
		vTerm = "uft";
		vSearchResult = "187 profiles available";
		//Click on see all freelancers
		myD.findElement(By.linkText("See all freelancers")).click();
		myD.findElement(By.id("s")).sendKeys(vTerm);
		myD.findElement(By.id("s")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		//Get results
		myResult = myD.findElement(By.className("plural")).getText();
		System.out.println(myResult);
		if(myResult.equals(vSearchResult)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
		
	}
	
	//@Ignore
	@Test
	public void TC03() throws InterruptedException {
		System.out.println("TestCase03 Execution");
		vTerm = "python";
		vSearchResult = "146 profiles available";
		//Click on see all freelancers
		myD.findElement(By.linkText("See all freelancers")).click();
		myD.findElement(By.id("s")).sendKeys(vTerm);
		myD.findElement(By.id("s")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		//Get results
		myResult = myD.findElement(By.className("plural")).getText();
		System.out.println(myResult);
		if(myResult.equals(vSearchResult)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
		
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod-Ending TC Execution");
		myD.close();
		myD.quit();
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("AfterClass");
	}
	
	@AfterTest
	public static void afterTest() {
		System.out.println("AfterTest");
	}
	
	@AfterSuite
	public static void afterSuite() {
		System.out.println("AfterSuite");
	}

}
