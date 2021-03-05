package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class WalletHubWriteReviewPage extends BaseClass {

	public WalletHubWriteReviewPage()	
	{
		PageFactory.initElements(BaseClass.driver, this);
	}

	@FindBy(xpath="//*[(@class='dropdown-placeholder')and((contains(text(),'Select')))]")
	WebElement dropdown_product;

	@FindBy(xpath="//*[(@class='dropdown-placeholder')and((contains(text(),'Select')))]//following-sibling::ul/li")
	List<WebElement> dropdown_product_options;

	@FindBy(xpath="//*[contains(@placeholder,'Write your review')]")
	WebElement text_write_review;

	@FindBy (xpath="//*[text()='Submit']")
	WebElement button_submit;

	@FindBy (xpath="//*[text()='Your review has been posted.']")
	WebElement review_confirm;	


	public void select_product(String selection) {
		click_on_element(dropdown_product);
		click_on_element(search_element_from_list(dropdown_product_options,selection));		
	}

	public void click_on_write_review() {
		click_on_element(text_write_review);
	}

	public void write_review(String review) {
		enter_text(text_write_review, review);
	}

	public void submit_review() {
		click_on_element(button_submit);
	}

	public boolean confirm_review_posted(){
		return check_for_element(review_confirm);

	}

}
