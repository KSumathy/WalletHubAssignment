package stepdefinitions;

import io.cucumber.java.en.Then;
import pages.FacebookHomePage;

public class FacebookHomePageSteps {	
	FacebookHomePage fb_home = new FacebookHomePage();
	
	@Then("post status message {string}")
	public void post_status_message(String message) {
		fb_home.click_on_enter_status();
		fb_home.enter_status(message);
		fb_home.add_to_report_with_snapshot("INFO", "Enter Status Message");	
		fb_home.click_post_status();
		fb_home.add_to_report_with_snapshot("PASS", "After Clicking Post Button");
	    
	}

}
