package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class WalletHubLoginPage extends BaseClass {
	
	public WalletHubLoginPage()	
	{
		PageFactory.initElements(BaseClass.driver, this);
	}

	@FindBy(xpath="//a[text()='Login']//parent::li")
	WebElement tab_login;

	@FindBy(xpath="//*[text()='Login']//parent::li[@class='selected']//following::input[@placeholder='Email Address']")
	WebElement input_username;

	@FindBy(xpath="//*[text()='Login']//parent::li[@class='selected']//following::input[@placeholder='Password']")
	WebElement input_password;

	@FindBy(xpath="//*[text()='Login']//ancestor::button")
	WebElement button_login;



	public void click_on_login_tab() {
		click_on_element(tab_login);	
	}

	public void enter_username(String username) {
		enter_text(input_username,username);
	}

	public void enter_password(String password) {
		enter_text(input_password, password);
	}

	public void click_on_login_button() {
		click_on_element(button_login);
	}

}
