package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	@Test(groups = {"Sanity","Master"})
	public void verify_login() {
		logger.info("*** Starting TC002_LoginTest **** ");

		try {
			HomePage hp = new HomePage(driver); // from HomePage
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver); // from LoginPage
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();

			// From MyAccountPage
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.isMyAccountPageExists();
			Assert.assertTrue(targetPage);
			// Assert.assertEquals(targetPage, true,"Login Failed");// Assert.asserEquals()
			// also accept 3 parameter
			// if login failed failed msg displayed "Login Failed"
		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("*** Finished TC002_LoginTest **** ");
	}

}
