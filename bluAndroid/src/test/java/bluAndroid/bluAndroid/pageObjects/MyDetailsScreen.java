package bluAndroid.bluAndroid.pageObjects;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

public class MyDetailsScreen {
	private AppiumDriver<WebElement> driver;
	public MyDetailsScreen()
	{
		
	}
	public MyDetailsScreen(AppiumDriver<WebElement> driver2) throws IOException {
		this.driver = driver2;
	}
	public void clickOnMyDetails()
	{
		WebElement menu=driver.findElement(By.id("sg.com.blu.android:id/menuButton"));
		menu.click();
		WebElement myDetails=driver.findElement(By.id("sg.com.blu.android:id/myDetailsTextView"));
		myDetails.click();
	}
	
	public void clickOneditIconFirstName()
	{
		WebElement firstNameEditIcon=driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='sg.com.blu.android:id/first_name_profileDisplayField']//android.widget.ImageButton[@resource-id='sg.com.blu.android:id/edit_btn']"));
		firstNameEditIcon.click();
	}
	public void clickOneditIconLastName()
	{
		WebElement lastNameEditIcon=driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='sg.com.blu.android:id/last_name_profileDisplayField']//android.widget.ImageButton[@resource-id='sg.com.blu.android:id/edit_btn']"));
		lastNameEditIcon.click();
	}
	public void clickOneditIconMobile()
	{
		WebElement MobileEditIcon=driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='sg.com.blu.android:id/mobile_profileDisplayField']//android.widget.ImageButton[@resource-id='sg.com.blu.android:id/edit_btn']"));
		MobileEditIcon.click();
	}
	public void clickOneditIconEmail()
	{
		WebElement emailEditIcon=driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='sg.com.blu.android:id/email_profileDisplayField']//android.widget.ImageButton[@resource-id='sg.com.blu.android:id/edit_btn']"));
		emailEditIcon.click();
	}
	public void clickOneditIconDOB()
	{
		WebElement dobEditIcon=driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='sg.com.blu.android:id/dob_profileDisplayField']//android.widget.ImageButton[@resource-id='sg.com.blu.android:id/edit_btn']"));
		dobEditIcon.click();
	}
	public void clickOneditIconGender()
	{
		WebElement genderEditIcon=driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='sg.com.blu.android:id/gender_profileDisplayField']//android.widget.ImageButton[@resource-id='sg.com.blu.android:id/edit_btn']"));
		genderEditIcon.click();
	}
}
