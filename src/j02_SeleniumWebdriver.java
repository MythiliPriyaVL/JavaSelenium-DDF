import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class j02_SeleniumWebdriver {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("~~~~~~~~~~Start of Test~~~~~~~~~~~~");
		
		String vTerm, vSearchResult, myResult;
		vTerm = "selenium";
		vSearchResult = "1130 profiles available";
		
		String bUrl = "https://qaonair.com/";
		String chromeDriver = "C:\\Users\\Mythili\\Software\\chromedriver.exe";
		
		//Go to AUT
		WebDriver myD;
		System.setProperty("webdriver.chrome.driver",chromeDriver);
		myD = new ChromeDriver();
		myD.navigate().to(bUrl);
		
		Thread.sleep(1000);
		
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
		myD.close();
		
		System.out.println("~~~~~~~~~~End of Test~~~~~~~~~~~~");

	}

}
