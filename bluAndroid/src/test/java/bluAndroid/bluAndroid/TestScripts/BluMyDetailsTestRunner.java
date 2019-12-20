package bluAndroid.bluAndroid.TestScripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import bluAndroid.bluAndroid.pageObjects.LoginScreen;
import bluAndroid.bluAndroid.pageObjects.MyDetailsScreen;
import bluAndroid.bluAndroid.util.BaseClass;
import bluAndroid.bluAndroid.util.CommonUtil;
import io.appium.java_client.AppiumDriver;

public class BluMyDetailsTestRunner extends BaseClass {
	static AppiumDriver<WebElement> driver;
	LoginScreen ls;
	String mobileNo, password;
	MyDetailsScreen mds;
	@BeforeMethod
	public void preCondition() throws IOException

	{
		System.out.println("Set Up....");
		BluMyDetailsTestRunner.driver = BaseClass.getAppCapabilities();
		mobileNo = CommonUtil.getPropertyValue("login", "mobileNo");
		password = CommonUtil.getPropertyValue("login", "password");
		ls = new LoginScreen(driver);
		ls.clickLoginLink();
		ls.bluLogin(mobileNo, password);
		mds=new MyDetailsScreen(driver);
	}

	public void displayText()
	{

	    System.out.println("i will display all the text and each of their languages");

	    // I find all the elements on the page as such
	    List<WebElement> list = driver.findElements(By.xpath("//*"));


	    assertTrue(list.size()>0) ;

	    System.out.println(list.size());

	    for(int i=0;i<list.size();i++)
	    { if (list.get(i).getText()!= null) {
	        String SeenText = list.get(i).getText();
	        System.out.println(SeenText);

	    }}

	}
	@Test
	public void tc01_editFirstName() throws IOException {
		System.out.println("tc01_editFirstName");
		extentTest = extentReports.createTest("tc01_editFirstName()");
		mds.clickOnMyDetails();
		mds.clickOneditIconFirstName();
		WebElement firstNameEdit=driver.findElement(By.id("sg.com.blu.android:id/input_text_et"));
		firstNameEdit.sendKeys("Hari");
		WebElement selectTick=driver.findElement(By.id("sg.com.blu.android:id/tick_btn"));
		selectTick.click();
		WebElement displayFirstname=driver.findElement(By.id("sg.com.blu.android:id/display_tv"));
		System.out.println(displayFirstname.getText());
		Assert.assertEquals(displayFirstname.getText(), "Hari");
		mds.clickOneditIconFirstName();
		firstNameEdit.sendKeys("Urvashi");
		selectTick.click();
		System.out.println(displayFirstname.getText());
	}
	@Test
	public void tc02_UnableToEditFirstName() throws IOException {
		System.out.println("tc02_UnableToEditFirstName");
		extentTest = extentReports.createTest("tc02_UnableToEditFirstName()");
		mds.clickOnMyDetails();
		mds.clickOneditIconFirstName();
		WebElement firstNameEdit=driver.findElement(By.id("sg.com.blu.android:id/input_text_et"));
		firstNameEdit.sendKeys("Hari@");
		WebElement selectTick=driver.findElement(By.id("sg.com.blu.android:id/tick_btn"));
		selectTick.click();
		//WebElement invalidFirstNameError=driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='sg.com.blu.android:id/first_name_profileDisplayField']//android.widget.TextView[@resource-id='sg.com.blu.android:id/error_tv']"));
		WebElement invalidFirstNameError=driver.findElement(By.id("sg.com.blu.android:id/error_tv"));
		System.out.println(invalidFirstNameError.getText());
		Assert.assertEquals(invalidFirstNameError.getText(), "Only alphabets and spaces allowed.");
		//mds.clickOneditIconFirstName();
		firstNameEdit.sendKeys("Urvashi");
		selectTick.click();
	}
	@Test
	public void tc03_editLastName() throws IOException {
		System.out.println("tc01_editFirstName");
		extentTest = extentReports.createTest("tc01_editFirstName()");
		mds.clickOnMyDetails();
		mds.clickOneditIconLastName();
		WebElement lastNameEdit=driver.findElement(By.id("sg.com.blu.android:id/input_text_et"));
		lastNameEdit.sendKeys("Lee");
		WebElement selectTick=driver.findElement(By.id("sg.com.blu.android:id/tick_btn"));
		selectTick.click();
		WebElement displayLastname=driver.findElement(By.id("//android.widget.FrameLayout[@resource-id='sg.com.blu.android:id/last_name_profileDisplayField']//android.widget.EditText[@resource-id='sg.com.blu.android:id/input_text_et']"));
		System.out.println(displayLastname.getText());
		Assert.assertEquals(displayLastname.getText(), "Lee");
		mds.clickOneditIconLastName();
		lastNameEdit.sendKeys("Gupta");
		selectTick.click();
	}
	@AfterMethod
	public void getResult(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.SKIP) {
			System.out.println("Skipped extent report");
			extentTest.skip(MarkupHelper.createLabel(testResult.getName() + " Test Case SKIPPED", ExtentColor.BLUE));
			extentTest.skip(testResult.getThrowable());
			// extentTest.log(Status.SKIP, MarkupHelper.createLabel(testResult.getName() + "
			// - Test Case Skipped", ExtentColor.ORANGE));
		} else if (testResult.getStatus() == ITestResult.FAILURE) {
			extentTest.fail(MarkupHelper.createLabel(testResult.getName() + " Test case FAILED due to below issues:",
					ExtentColor.RED));
			extentTest.fail(testResult.getThrowable());
			String screenshotPath = CommonUtil.takesScreenShotFailed(driver, testResult.getName());
			extentTest.addScreenCaptureFromPath(screenshotPath);
		} else if (testResult.getStatus() == ITestResult.SUCCESS) {
			extentTest.pass(MarkupHelper.createLabel(testResult.getName() + " Test Case PASSED", ExtentColor.GREEN));
			String screenshotPath = CommonUtil.takesScreenShot(driver, testResult.getName());

			extentTest.addScreenCaptureFromPath(screenshotPath);
		}

	}
}
