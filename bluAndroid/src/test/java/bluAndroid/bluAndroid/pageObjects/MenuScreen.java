package bluAndroid.bluAndroid.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

public class MenuScreen {
	private static AppiumDriver<WebElement> driver;
	public MenuScreen()
	{
		
	}
	 
	public MenuScreen(AppiumDriver<WebElement> driver)
	{
		this.driver=driver;
	}
	
	public void logout()
	{
		WebElement menu=driver.findElement(By.id("sg.com.blu.android:id/menuButton"));
		menu.click();
		WebElement logout=driver.findElement(By.id("sg.com.blu.android:id/logOutTextView"));
		logout.click();
	}
	
	public void clickOnPricing()
	{
		WebElement pricing=driver.findElement(By.id("sg.com.blu.android:id/pricingTextView"));
		pricing.click();
	}
	public void clickOnPointsAndRewards()
	{
		WebElement pointsRewards=driver.findElement(By.id("sg.com.blu.android:id/pointsRewardsTextView"));
		pointsRewards.click();
	}
	public void settings()
	{
		WebElement menu=driver.findElement(By.id("sg.com.blu.android:id/menuButton"));
		menu.click();
		WebElement settings=driver.findElement(By.id("sg.com.blu.android:id/settingsTextView"));
		settings.click();
	}
	public void savedLocations()
	{
		WebElement savedLocations=driver.findElement(By.id("sg.com.blu.android:id/savedLocationsTextView"));
		savedLocations.click();
	}
	public void myParcels()
	{
		WebElement myParcels=driver.findElement(By.id("sg.com.blu.android:id/myParcelsTextView"));
		myParcels.click();
	}
}
