package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class FacebookHomePage extends BaseClass {	

	public FacebookHomePage()	
	{
		PageFactory.initElements(BaseClass.driver, this);
	}


	@FindBy(xpath="//*[contains(text(),'on your mind,')]")
	WebElement enter_status;	


	@FindBy(xpath="//*[@role='dialog']//*[@role='textbox']")
	WebElement txt_status;	


	@FindBy(xpath="//*[@role='button']//*[text()='Post']")
	WebElement button_post;

	@FindBy(xpath="//*[@role='dialog'] //form[@method='POST']")
	WebElement dialog_create_post;

	@FindBy(xpath="//*[@role='feed']/div")
	List<WebElement> feeds_list;


	public void enter_status(String message)	{
		enter_text(txt_status, message);
	}	

	public void click_on_enter_status() {
		click_on_element(enter_status);
	}

	public void click_post_status() {
		click_on_element(button_post);	

	}

}
