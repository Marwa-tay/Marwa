package pack;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class Base {
	
	public static WebDriver driver; 
	@BeforeMethod
	
	public void AvantTest() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\21653\\Desktop\\selenium_formation\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.get("https://fr-fr.facebook.com/");}
	
	//@AfterMethod
	
	//public void apresTest() {
		//driver.close();}
	public void getscreen() throws IOException{
		
	long a = System.currentTimeMillis ();
	File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scr, new File("C:\\Users\\21653\\Desktop\\selenium_formation\\"+a+"screenshot.png"));}

}
