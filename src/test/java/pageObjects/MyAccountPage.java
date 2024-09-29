package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[text()='My Account']") // My Account Page Heading
	WebElement msgHeading;
	
	@FindBy(xpath = "//div[@class='list-group']/child::a[text()='Logout']")
	WebElement InkLogout;

	public boolean isMyAccountPageExists() {   //verify MyAccountPage is exists or not

		try {
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}
	
	public void clickLogout()
	{
		InkLogout.click();
	}
}
 