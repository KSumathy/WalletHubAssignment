package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class WalletHubProfilePage extends BaseClass {
	
	public WalletHubProfilePage()	
	{
		PageFactory.initElements(BaseClass.driver, this);
	}

	@FindBy(xpath="//*[text()=' Your Review']//preceding::div[@itemprop='itemReviewed']//following-sibling::div[@itemprop='description']")
	WebElement my_review;

	@FindBy(xpath="//a[text()='My Wallet']//following-sibling::div[4]")
	WebElement hover_my_name;

	@FindBy(xpath="//a[text()='My Wallet']//following-sibling::div[4]//following::*[text()='Profile']")
	WebElement my_profile;

	
	public void hover_on_myname_and_click_profile() {
		hover_on_element_and_click(hover_my_name, my_profile);		
	}

	public String get_review_text() {		
		return get_text(my_review);
	}

}
