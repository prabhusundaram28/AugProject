package projectTask;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EcommerceUsingDataProvider {
	
	@Test (dataProvider ="mobiles")
	public void MobilePhone(String passing) throws AWTException {
		System.setProperty("webdriver.chrome.driver", "E:\\Automation Testing profile\\Automation_Workspaces\\Workspace_1\\Automation_Scripts\\Chrome_Driver\\chromedriver_V84.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
	driver.findElement(By.name("q")).sendKeys(passing);
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	
	List<WebElement> list_of_Products = driver.findElements(By.xpath("//Div[@class='_3wU53n']"));
	for (int i = 0; i <list_of_Products.size(); i++) {
		System.out.println(list_of_Products.get(i).getText());
	}
	driver.quit();
	}
   @DataProvider (name="mobiles")
	public Object[][] add() {
		return new Object[][] {{"redmi mobiles"},{"samsung mobiles"},{"poco mobiles"},{"]lenovo mobiles"},{"iphone mobiles"},{"panasonic mobiles"},{"micromax mobiles"},{"oneplus mobiles"}};
	}
}
