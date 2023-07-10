package rsa.AbstractComponent;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class AbstractComponent {

	WebDriver driver;
	public Actions a; 
	
	public AbstractComponent(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public JavascriptExecutor scroll()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1200)");
		return js;
	}
	
	public void getWindowHandles()
	{
		Set<String>handles= driver.getWindowHandles();
		Iterator<String> it= handles.iterator();
		String parentWindow=it.next();
		String childWindow= it.next();
		driver.switchTo().window(childWindow);
		System.out.println(driver.getTitle()); 
		driver.switchTo().window(parentWindow);
	}
	
}
