package rsa.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import rsa.pageobjects.PracticePage;

public class BaseTest {

	public WebDriver driver;
	public PracticePage pp;
	
	public WebDriver initailizeDriver() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+
				"\\src\\main\\java\\rsa\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName=System.getProperty("browser")!= null ? System.getProperty("browser") : prop.getProperty("browser");
		if(browserName.contains("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(browserName.contains("headless"))
			{
				options.addArguments("headless");
			}
			driver=new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));
		}
		else if (browserName.contains("Firefox"))
		{
			//Firefox
		}
		else if (browserName.contains("Edge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Users\\cheta\\OneDrive\\Documents\\A\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File file= new File(System.getProperty("user.dir")+ "//reports//" +testCaseName+ "//.png//");
		FileHandler.copy(source, file);
		return System.getProperty("user.dir")+ "//reports//" +testCaseName+ "//.png//";
	}
	
	@BeforeMethod(alwaysRun=true)
	public PracticePage setup() throws IOException
	{
		driver=initailizeDriver();
		pp=new PracticePage(driver);
		pp.goTo();
		return pp;
	}
	
	/*@AfterMethod(alwaysRun=true)
	public void tearDown()
	{
		driver.close();
	}*/
}
