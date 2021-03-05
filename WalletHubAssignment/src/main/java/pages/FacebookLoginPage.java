package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class FacebookLoginPage extends BaseClass {

	public FacebookLoginPage()	
	{
		PageFactory.initElements(BaseClass.driver, this);
	}

	@FindBy(id="email")
	WebElement text_username;	

	@FindBy(id="pass")
	WebElement text_password;	

	@FindBy(xpath="//button[@type='submit']")
	WebElement button_login;

	public void enter_username(String data)	{
		enter_text(text_username, data);
	}

	public void enter_password(String data) {
		enter_text(text_password,data);
	}

	public void click_login_button() {
		click_on_element(button_login);
	}
}
