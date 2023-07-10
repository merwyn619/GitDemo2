package rsa.tests;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rsa.TestComponents.BaseTest;

public class PracticePageTest extends BaseTest{

	//public WebDriver driver;
	
	@Test(dataProvider="getData")
	public void practice(HashMap<String,String> input)
	{
		pp.logo();
		pp.radio1();
		pp.autoSuggestion();
		pp.selectDropdown();
		pp.selectFromDropdown();
		pp.checkboxOption3();
		pp.openWindow();
		pp.getWindowHandles();
		pp.openTab();
		pp.getWindowHandles();
		pp.name(input.get("name2"));
		pp.alert();
		pp.confirm();
	    pp.displayedText(input.get("displayedText2"));
	    pp.hide();
	    //Assert.assertFalse(pp.displayedText(input.get("displayedText2")).isDisplayed()); 
	    pp.show();
	    //System.out.println(pp.displayedText(input.get("displayedText2")).isDisplayed());
	    pp.mouseHover();
	    pp.top();
	    pp.reload();
	    pp.iFrame();
	}
	
	@Test
	public void practice2()
	{
		pp.radio1();
		pp.autoSuggestion();
		pp.selectDropdown();
		pp.selectFromDropdown();
		pp.checkboxOption3();
		//pp.sumTotal();
		//Assert.assertEquals(pp.sum, pp.total);
		pp.sum2();
	}
	
	@DataProvider
	public Object[] getData()
	{
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("name2", "Merwyn");
		map.put("displayedText2", "Atul");
		
		return new Object[] {map};
	}
}
