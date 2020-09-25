import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class j03_Junit {
	String bUrl = "https://qaonair.com/";
	String chromeDriver = "C:\\Users\\Mythili\\Software\\chromedriver.exe";	
	String vTerm, vSearchResult, myResult;	
	WebDriver myD;
	
	@BeforeClass
	public static void preClass() {
		System.out.println("Start Test");
	}
	
	@Before
	public void preTest() throws InterruptedException {
		System.out.println("Starting Execution");						
		System.setProperty("webdriver.chrome.driver",chromeDriver);
		myD = new ChromeDriver();
		myD.navigate().to(bUrl);		
		Thread.sleep(1000);
	}
	
	@Test
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
	
	@Test
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
	
	@After
	public void postTest() {
		System.out.println("Ending Execution");
		myD.close();
		myD.quit();
	}
	
	@AfterClass
	public static void postClass() {
		System.out.println("End Test");
	}
}
