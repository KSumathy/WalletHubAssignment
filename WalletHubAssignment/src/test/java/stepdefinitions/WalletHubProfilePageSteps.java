package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.WalletHubProfilePage;

public class WalletHubProfilePageSteps {

	WalletHubProfilePage pp= new WalletHubProfilePage();

	@And("Go to my profile")
	public void go_to_my_profile() {
		pp.hover_on_myname_and_click_profile();
		pp.add_to_report_with_snapshot("INFO", "After clicking Profile");
	}

	@Then("verify message {string} is posted")
	public void verify_message_is_posted(String message) {

		Assert.assertEquals(pp.get_review_text(), message);
		pp.add_to_report_with_snapshot("PASS", "Review is Posted");
	}

}
