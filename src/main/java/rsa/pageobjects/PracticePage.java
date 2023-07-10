package rsa.pageobjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import rsa.AbstractComponent.AbstractComponent;

public class PracticePage extends AbstractComponent {

	WebDriver driver;
	public int sum, total=0;
	
	public PracticePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".logoClass")
	WebElement logo;
	
	@FindBy(css="[value='radio1']")
	WebElement radio1;
	
	@FindBy(id="autocomplete")
	WebElement autoSuggestion;
	
	@FindBy(css=".ui-menu-item")
	List<WebElement> values;
	
	@FindBy(css="[id*='dropdown']")
	WebElement selectDropdown;
	
	@FindBy(id="checkBoxOption3")
	WebElement checkboxOption3;
	
	@FindBy(id="openwindow")
	WebElement openWindow;
	
	@FindBy(id="opentab")
	WebElement openTab;
	
	@FindBy(id="name")
	WebElement name;
	
	@FindBy(id="alertbtn")
	WebElement alert;
	
	@FindBy(id="confirmbtn")
	WebElement confirm;
	
	@FindBy(id="displayed-text")
	WebElement displayedText;
	
	@FindBy(id="hide-textbox")
	WebElement hide;
	
	@FindBy(id="show-textbox")
	WebElement show;
	
	@FindBy(id="mousehover")
	WebElement mouseHover;
	
	@FindBy(css=".mouse-hover-content a:first-of-type")
	WebElement top;
	
	@FindBy(css=".mouse-hover-content a:last-of-type")
	WebElement reload;
	
	@FindBy(id="courses-iframe")
	WebElement iFrame;
	
	@FindBy(css="[class*='view-all']")
	WebElement viewAllCourses;
	
	@FindBy(css=".tableFixHead td:nth-child(4)")
	List<WebElement> values2;
	
	@FindBy(css=".totalAmount")
	WebElement totalAmount;
	
	@FindBy(css=".table-display td:nth-child(3)")
	List<WebElement> values3;	
	
	public void logo()
	{
		logo.click();
		driver.navigate().back();
		//return logo;
	}
	
	public WebElement radio1()
	{
		radio1.click();
		return radio1;
	}
	
	public WebElement autoSuggestion()
	{
		autoSuggestion.sendKeys("Ind");
		for(int i=0;i<values.size();i++)
		{
			if(values.get(i).getText().equalsIgnoreCase("India"))
			{
				values.get(i).click();
				break;
			}
		}
		return autoSuggestion;
	}
	
	public WebElement selectDropdown()
	{
		selectDropdown.click();
		return selectDropdown;
	}
	
	public void selectFromDropdown()
	{
		Select s=new Select(selectDropdown());
		s.selectByVisibleText("Option1");
		//s.selectByIndex(2);
	}
	
	public WebElement checkboxOption3()
	{
		checkboxOption3.click();
		return checkboxOption3;
	}
	
	public WebElement openWindow()
	{
		openWindow.click();
		return openWindow;
	}
	
	public WebElement openTab()
	{
		openTab.click();
		return openTab;
	}
	
	public WebElement name(String name2)
	{
		name.sendKeys(name2);;
		return name;
	}
	
	public WebElement alert()
	{
		alert.click();
		driver.switchTo().alert().accept();
		return alert;
	}
	
	public WebElement confirm()
	{
		confirm.click();
		driver.switchTo().alert().dismiss();
		return confirm;
	}
	
	public WebElement displayedText(String displayedText2)
	{
		displayedText.sendKeys(displayedText2);
		return displayedText;
	}
	
	public WebElement hide()
	{
		hide.click();
		return hide;
	}
	
	public WebElement show()
	{
		show.click();
		return show;
	}
	
	public WebElement mouseHover()
	{
		scroll();
		a=new Actions(driver);
		a.moveToElement(mouseHover).build().perform();
		return mouseHover;
	}
	
	public WebElement top()
	{
		a=new Actions(driver);
		a.moveToElement(top).click().build().perform();
		return top;
	}
	
	public WebElement reload()
	{
		scroll();
		a=new Actions(driver);
		a.moveToElement(mouseHover).build().perform();
		a.moveToElement(reload).click().build().perform();
		return reload;
	}
	
	public WebElement iFrame()
	{
		scroll();
		System.out.println(iFrame.getSize()); 
	    driver.switchTo().frame(0);
	    viewAllCourses();
	    driver.switchTo().defaultContent();
		return iFrame;
	}
	
	public WebElement viewAllCourses()
	{
		a=new Actions(driver);
		a.moveToElement(viewAllCourses).click().build().perform();
		return viewAllCourses;
	}
	
	public List<WebElement> values2()
	{
		return values2;
	}
	
	public WebElement totalAmount()
	{
		return totalAmount;
	}
	
	public void sumTotal()
	{
		scroll();
		for(int i=0;i<values2().size();i++)
		{
			sum=sum+Integer.parseInt(values2().get(i).getText());
		}
		System.out.println(sum);
		
		total=Integer.parseInt(totalAmount().getText().split(":")[1].trim());
	
	}
	
	public List<WebElement> values3()
	{
		return values3;
	}
	
	public void sum2()
	{
		scroll();
		for(int i=0;i<values3().size();i++)
		{
			sum=sum+Integer.parseInt(values3().get(i).getText()); 
		}
		System.out.println(sum);
	}
	
	public void goTo()
	{
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
	}
}
