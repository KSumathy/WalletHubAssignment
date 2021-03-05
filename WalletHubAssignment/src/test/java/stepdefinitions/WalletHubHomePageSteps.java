package stepdefinitions;

import io.cucumber.java.en.Given;
import pages.WalletHubHomePage;
import utilities.BaseClass;

public class WalletHubHomePageSteps {
	BaseClass bc;
	WalletHubHomePage hp;
	@Given("Open Wallethub using {string} in {string}")
	public void open_wallethub_using_in(String url, String browser) {
		try {
			bc=new BaseClass();			
			bc.open_browser(browser);
			bc.launch_application(url);
			hp = new WalletHubHomePage();
			hp.add_to_report_with_snapshot("PASS", "WalletHub Profile page launched Successfully");
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}

	@Given("I click on fourth rating star")
	public void i_click_on_fourth_rating_star() {
		hp.hover_on_fourth_star();
		hp.add_to_report_with_snapshot("PASS", "After hovering on fourth star");
		hp.click_fourth_star();
		hp.add_to_report_with_snapshot("PASS", "After clicking on fourth star");
	}


}
