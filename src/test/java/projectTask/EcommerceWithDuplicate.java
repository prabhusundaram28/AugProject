package projectTask;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EcommerceWithDuplicate {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
		
		driver.findElement(By.name("q")).sendKeys("iphone");
		driver.findElement(By.xpath("//button[@class='vh79eN']")).click();
		
		List<WebElement> list_of_Products = driver.findElements(By.xpath("//div[@class='_3wU53n']"));
		
		System.out.println("The total no. of products are: " + list_of_Products.size());
		
	/*	Iterator<WebElement> itr = list_of_Products.iterator();
		while(itr.hasNext()) {
		    System.out.println(itr.next().getText());
		}*/
		
		List<String> allLists = new LinkedList<String>();
		
		for (WebElement products : list_of_Products) {
			String productNames = products.getText();
			//System.out.println("The product names are: " + productNames);
			allLists.add(productNames);
		}
		System.out.println(allLists);
		int listSize = allLists.size();
		System.out.println("The list size is: " + listSize);
		
		Set<String> allSets = new HashSet<String>();
		allSets.addAll(allLists);
		int setSize = allSets.size();
		System.out.println("The Set size is: " + setSize);
		
		int duplicateCount = listSize - setSize;
		System.out.println("The number of duplicate counts are: " + duplicateCount);
		driver.quit();
	} 		
}
