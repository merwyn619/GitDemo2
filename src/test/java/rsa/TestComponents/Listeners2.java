package rsa.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import rsa.resources.ExtentReporterNG;

public class Listeners2 extends BaseTest implements ITestListener{

	ExtentTest test;
	ExtentReports extent=ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>(); //Thread safe
	
	@Override
	public void onTestStart(ITestResult result)
	{
		test=extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test); //unique thread id
	}
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		//System.out.println("I successfully executed Listeners pass code");
		extentTest.get().log(Status.PASS, "Test Passed");
		
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		extentTest.get().fail(result.getThrowable());
		
		try
		{
		driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IOException e) {
		e.printStackTrace();
		}
		
		String filepath=null;
		
		filepath=getScreenshot(result.getMethod().getMethodName(), driver);
		
		extentTest.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
		//SS, Attach to report
	}
	
	@Override
	public void onTestSkipped(ITestResult result)
	{
		
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		
	}
	
	@Override
	public void onStart(ITestContext context)
	{
		
	}
	
	@Override
	public void onFinish(ITestContext context)
	{
		extent.flush();
	}
}
}
