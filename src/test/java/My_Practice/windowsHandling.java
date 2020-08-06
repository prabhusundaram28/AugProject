package My_Practice;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowsHandling {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver d=new ChromeDriver();
	d.get("https://www.kvb.co.in/ilogin/");
	d.manage().window().maximize();
	String ParentWindow=d.getWindowHandle();
	WebElement clickTOlogin=d.findElement(By.id("ilogin"));
	clickTOlogin.click();
	Set <String> childWindow=d.getWindowHandles();
	for (String newWindow : childWindow) {
		d.switchTo().window(newWindow);
	}
	WebElement  loginId=d.findElement(By.name("fldLoginUserId"));
	loginId.sendKeys("13216694");
	
}
}
