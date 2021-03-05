package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass extends Reporter {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static String url;
	public static ChromeOptions chrome_options;
	public static Select dropdown;
	public static Actions myaction;

	/*
	 * This is a baseclass for the framework that holds all the Selenium operations.
	 * 
	 */
	public void open_browser(String browser) throws Exception {
		try {
			switch (browser) {
			case "chrome": {
				chrome_options = new ChromeOptions();
				chrome_options.addArguments("--disable-notifications");
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver(chrome_options);
				break;
			}
			/*
			 * case "firefox": { System.setProperty("webdriver.gecko.driver",
			 * "./drivers/geckodriver.exe"); driver = new FirefoxDriver(); break; }
			 */

			default: {
				throw new Exception("Enter valid name for browser");

			}
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 20);
			myaction = new Actions(driver);
		} catch (Exception e) {
			add_to_report("Fail", "Could not open browser.Enter valid browser name");

		}
	}

	public void launch_application(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
			add_to_report("Fail", "Could not launch URL.Exception has occured.");
		}

	}

	public void enter_text(WebElement element, String data) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(data);
		} catch (Exception e) {
			e.printStackTrace();
			add_to_report("Fail", "Could not enter text.Exception has occured.");
		}

	}

	public void click_on_element(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
			add_to_report("Fail", "Could not click on element.Exception has occured.");
		}
	}

	
	public WebElement search_element_from_list(List<WebElement> list_elements, String text) {
		WebElement result = null;
		for (WebElement element : list_elements) {		  
			if(element.getText().contains(text)) {
				wait.until(ExpectedConditions.visibilityOf(element));
				result= element;
				break; 
			}
		}
		return result;

	}
	
	public boolean check_for_element(WebElement element) {
		
		return element.isDisplayed();
	}
	
	public String get_text(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		return (element.getText());
	}
	
	public void hover_on_element_and_click(WebElement hover_element,WebElement click_element) {
		wait.until(ExpectedConditions.visibilityOf(hover_element));		
		//hover_element.click();
		//click_element.click();
		/*
		 * JavascriptExecutor ex = (JavascriptExecutor)driver;
		 * ex.executeScript("arguments[0].click();", hover_element);
		 * ex.executeScript("arguments[0].click();", click_element);
		 */
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hover_element);
		myaction.moveToElement(hover_element).perform();
		//myaction.click(hover_element).moveToElement(click_element).click(click_element).build().perform();
		//action.moveToElement(hover_element).click(click_element).build().perform();
	}
	
	public void hover_on_element(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));	
		myaction.moveToElement(element).perform();
	}


	public void kill_driver() {
		driver.quit();
	}

	/*
	 * public void take_snapshot() { try { String timeFrame = new
	 * SimpleDateFormat("yyyyMMddhhss").format(new Date()); TakesScreenshot
	 * screenshot = (TakesScreenshot) driver; File source =
	 * screenshot.getScreenshotAs(OutputType.FILE); String filePath =
	 * System.getProperty("user.dir") + "/Screenshots/Snapshot_" + timeFrame +
	 * ".png"; File destination = new File(filePath); FileUtils.copyFile(source,
	 * destination); add_snapshot(filePath); } catch (IOException e) {
	 * e.printStackTrace(); add_to_report("Info",
	 * "Could not take screenshot.IO Exception has occured."); } }
	 */

	public void add_to_report_with_snapshot(String status, String description) {
		try {
			String timeFrame = new SimpleDateFormat("yyyyMMddhhss").format(new Date());
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File source = screenshot.getScreenshotAs(OutputType.FILE);
			String filePath = System.getProperty("user.dir") + "/Screenshots/Snapshot_" + timeFrame + ".png";
			File destination = new File(filePath);
			FileUtils.copyFile(source, destination);
			add_snapshot_to_report(status, description, filePath);
		} catch (IOException e) {
			e.printStackTrace();
			add_to_report("Info", "Could not take screenshot.IO Exception has occured.");
		}

	}

}
