package stepdefinitions;

import io.cucumber.java.en.Then;
import pages.WalletHubLoginPage;

public class WalletHubLoginPageSteps {
	WalletHubLoginPage lp = new WalletHubLoginPage();	

	@Then("click on login tab")
	public void click_on_login_tab() {
		lp.click_on_login_tab();
		lp.add_to_report_with_snapshot("INFO", "After clicking on Login tab");
	}

	@Then("enter {string} and {string}")
	public void enter_and(String username, String password) {
		lp.enter_username(username);
		lp.enter_password(password);
		lp.add_to_report_with_snapshot("INFO", "After entering username and password");	
	}

	@Then("click login button")
	public void click_on_login_button() {
		lp.click_on_login_button();
		lp.add_to_report_with_snapshot("INFO", "After clicking on Login button");
	}

}