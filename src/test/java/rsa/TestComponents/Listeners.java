package rsa.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import rsa.resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener{
	

	ExtentTest test;
	ExtentReports extent=ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>(); //Thread safe
	
	public void onTestStart(ITestResult result)
	{
		test=extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test); //unique thread id
	}
	
	public void onTestSuccess(ITestResult result)
	{
		//System.out.println("I successfully executed Listeners pass code");
		extentTest.get().log(Status.PASS, "Test Passed");
		
	}
	
	public void onTestFailure(ITestResult result)
	{
		extentTest.get().fail(result.getThrowable());
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance()); 
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String filepath=null;
		
		try {
			filepath=getScreenshot(result.getMethod().getMethodName(), driver);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extentTest.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
		//SS, Attach to report
}
	
	public void onTestSkipped(ITestResult result)
	{
		
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		
	}
	
	public void onStart(ITestContext context)
	{
		
	}
	
	public void onFinish(ITestContext context)
	{
		extent.flush();
	}
}

