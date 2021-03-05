package stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.FacebookLoginPage;
import utilities.BaseClass;

public class FacebookLoginPageSteps{		
	FacebookLoginPage fb ;
	BaseClass bc;
	@Given("Open facebook using {string} in {string}")
	public void open_facebook_using_in(String url, String browser) {
		try {
			bc=new BaseClass();			
			bc.open_browser(browser);
			bc.launch_application(url);
			fb = new FacebookLoginPage();
			fb.add_to_report_with_snapshot("PASS", "Facebook launched Successfully");
		} catch (Exception e) {
			e.printStackTrace(); 
		}

	}

	@Given("Enter {string} and {string}")
	public void enter_and(String username, String password) {
		fb.enter_username(username);
		fb.enter_password(password);
		fb.add_to_report_with_snapshot("INFO", "Enter Username and Password");
	}

	@When("I click on Login button")
	public void i_click_on_login_button() {
		fb.click_login_button();
		fb.add_to_report_with_snapshot("INFO", "Click on Login Button");
	}



}
