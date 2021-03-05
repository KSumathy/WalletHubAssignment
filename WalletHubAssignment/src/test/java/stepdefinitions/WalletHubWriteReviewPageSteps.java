package stepdefinitions;

import io.cucumber.java.en.Then;
import junit.framework.Assert;
import pages.WalletHubWriteReviewPage;

public class WalletHubWriteReviewPageSteps {

	WalletHubWriteReviewPage rwp = new WalletHubWriteReviewPage();

	@Then("select product as {string}")
	public void select_product_as(String product) {	
		rwp.select_product(product);
		rwp.add_to_report_with_snapshot("PASS", "After selecting product");
	}

	@Then("write review {string}")
	public void write_review(String review) {
		rwp.write_review(review);
		rwp.add_to_report_with_snapshot("PASS", "After entering review");

	}

	@Then("click on submit button")
	public void click_on_submit_button() {
		rwp.submit_review();
	}

	@Then("confirm review posted")
	public void confirm_review_posted() {
		if(rwp.confirm_review_posted())
			rwp.add_to_report_with_snapshot("PASS", "Review is posted");
		else
			rwp.add_to_report_with_snapshot("FAIL", "Review is not posted");

	}


}
