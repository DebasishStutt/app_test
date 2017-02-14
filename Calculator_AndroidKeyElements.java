import static org.junit.Assert.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Calculator_AndroidKeyElements {

	@Test
	public void test() throws MalformedURLException {

		File appDir = new File("src");
		   
	    File app = new File(appDir, "Calculator_v1.10.9_apkpure.com.apk");

	    //Setting DesiredCapabilities///////////////////////
	    
	DesiredCapabilities cap=new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android emulator");
	
	cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "20");
	cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	
	///////////////////////////////////////////////////////////////
	
	
	AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap );
	
	WebDriverWait wait = new WebDriverWait(driver, 200);
	
	WebElement e = driver.findElement(By.name("Welcome"));
	
	//if(e.getText()=="Welcome")
	//{
		//System.out.println("Found");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("OK")));
		
		
		e = driver.findElement(By.id("com.tricolorcat.calculator:id/btOK"));
		
		e.click();
		//System.out.println("clicked");
	//}
	
	List<WebElement> tableRows = driver.findElements(By.className("android.widget.TableRow"));
	
	System.out.println(tableRows.size());
	
	WebElement multButton = driver.findElementByAndroidUIAutomator("new UiSelector().text(\"x\")");
	
	tableRows.get(1).findElement(By.name("7")).click();
	multButton.click();
	
	tableRows.get(1).findElement(By.name("8")).click();
	
	tableRows.get(4).findElement((By.name("="))).click();
	System.out.println("here");
	
	////NOTE
	driver.pressKeyCode(AndroidKeyCode.HOME);
	//driver.pressKeyCode((AndroidKeyCode.);
	
	
	
	
	
	/*WebDriverWait wait = new WebDriverWait(driver, 200);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("de.hoomn.app:id/terms_accept_button")));
	
	System.out.println(driver.getContext());
	
	List<WebElement> acceptButton = driver.findElementsByAndroidUIAutomator("new UiSelector().text(\"ACCEPT\")");
	*/
	//System.out.println(acceptButton.get(0).getText());
	//acceptButton.get(0).click();
	
	
	//WebElement acceptButton = driver.findElementByAndroidUIAutomator("new UiSelector().text(\"ACCEPT\")");
	
	
	/*System.out.println(acceptButton.get(0).getText());
	
	TouchAction t = new TouchAction(driver);
	
	t.tap(acceptButton.get(0)).perform();
	//wait.until(ExpectedConditions.presenceOfElementLocated(By.name("ACCEPT")));
	
	//t.tap(acceptButton).perform();
	 * 
	 */
	}
	
	
}