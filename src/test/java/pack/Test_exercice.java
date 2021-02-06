package pack;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test_exercice extends Base {
	
	
	@Test(dataProvider ="getdata")
	public void Test1(String username, String PW) throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(username);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(PW);}
	   
		
	


@DataProvider
public Object[] [] getdata() {
	
	Object[][] data = new Object [3][2];
	
	//Combinaison1
	data[0][0] = "user1";
	data[0][1] = "PW1";
	//Combinaison2
	data[1][0] = "user2";
	data[1][1] = "PW2";
	//Combinaison3
	data[2][0] = "user 3";
	data[2][1] = "PW3";
	
	return data;
	
	
	
	

}
}


