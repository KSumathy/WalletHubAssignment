package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class WalletHubHomePage extends BaseClass {
	
	public WalletHubHomePage()	
	{
		PageFactory.initElements(BaseClass.driver, this);
	}

	@FindBy(xpath="//*[@class='rvs-svg']//*[@class='rvs-star-svg'][4]")
	WebElement star_four;

	@FindBy(xpath="//*[text()='Test Insurance Company']")
	WebElement my_recommendations;


	public void hover_on_fourth_star() {
		hover_on_element(star_four);
	}

	public void click_fourth_star() {
		click_on_element(star_four);
	}
	public void click_recommendations() {
		click_on_element(my_recommendations);

	}



}
