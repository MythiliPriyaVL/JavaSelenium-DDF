import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class j04_FuntionalDecomposition {
	
	static String bUrl = "https://percentagecalculator.net/";
	static String chromeDriver = "C:\\Users\\Mythili\\Software\\chromedriver.exe";	
	static String result;	
	static WebDriver myD;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		startAut();
		result = percentageOf("10","2000");
		System.out.println(result);
		result = percentOf("100","1000");
		System.out.println(result);
		result = percentageIncDec("50","70");
		System.out.println(result);
		endAut();
				
	}

	public static void startAut() throws InterruptedException {
		System.out.println("Starting Execution");						
		System.setProperty("webdriver.chrome.driver",chromeDriver);
		myD = new ChromeDriver();
		myD.manage().window().maximize();
		myD.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		myD.navigate().to(bUrl);		
		Thread.sleep(3000);
	}
	
	public static String percentageOf(String input1,String input2) throws InterruptedException {
		System.out.println("What is "+ input1 +" % of "+ input2 +"?");
		myD.findElement(By.xpath("//*[@id=\'f1\']/fieldset[1]/input")).sendKeys(input1);
		myD.findElement(By.xpath("//*[@id=\'f1\']/fieldset[1]/nobr/input")).sendKeys(input2); 
		myD.findElement(By.xpath("//*[@id=\'f1\']/fieldset[2]/input[1]")).click();
		Thread.sleep(3000);
		result = myD.findElement(By.xpath("//*[@id=\'f1\']/fieldset[2]/input[2]")).getAttribute("value");
		return result;
	}
	
	public static String percentOf(String input1,String input2) throws InterruptedException {
		System.out.println(input1 +" is what percent of "+ input2 +"?");
		myD.findElement(By.xpath("//*[@id=\'f2\']/fieldset[1]/input")).sendKeys(input1);
		myD.findElement(By.xpath("//*[@id=\'f2\']/fieldset[1]/nobr/input")).sendKeys(input2); 
		myD.findElement(By.xpath("//*[@id=\'f2\']/fieldset[2]/input[1]")).click();
		Thread.sleep(3000);
		result = myD.findElement(By.xpath("//*[@id=\'f2\']/fieldset[2]/input[2]")).getAttribute("value");
		return result;
	}
	
	public static String percentageIncDec(String input1,String input2) throws InterruptedException {
		System.out.println("What is the percentage Increase/Decrease from "+ input1 +" to "+ input2 +"?");
		myD.findElement(By.xpath("//*[@id=\'f3\']/fieldset[1]/nobr[1]/input")).sendKeys(input1);
		myD.findElement(By.xpath("//*[@id=\'f3\']/fieldset[1]/nobr[2]/input")).sendKeys(input2); 
		myD.findElement(By.xpath("//*[@id=\'f3\']/fieldset[2]/input[1]")).click(); 
		Thread.sleep(3000);
		result = myD.findElement(By.xpath("//*[@id=\'f3\']/fieldset[2]/input[2]")).getAttribute("value");
		return result;
	}
	
	public static void endAut() {
		System.out.println("Ending Execution");
		myD.close();
		myD.quit();
	}
}
