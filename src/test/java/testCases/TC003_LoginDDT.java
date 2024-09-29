package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups = "Master") // getting dataprovider from another
																				// class
	public void verify_LoginDDT(String email, String pwd, String exp) throws Throwable {
		logger.info("*** Starting TC003_LoginDDT ***");
		try {
			HomePage hp = new HomePage(driver); // from HomePage
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver); // from LoginPage
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();

			// From MyAccountPage
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.isMyAccountPageExists();
			Assert.assertTrue(targetPage);

			// Data is valid -login success -test pass-logout (+ve)
			// login failed -test fail

			// Data is Invalid -login success -test fail-logout (-ve)
			// login failed-test pass

			if (exp.equalsIgnoreCase("Valid")) {

				if (targetPage == true) {
					macc.clickLogout();
					Assert.assertTrue(true);

				} else {
					Assert.assertTrue(false);
				}
			}
			if (exp.equalsIgnoreCase("Invalid")) {

				if (targetPage == true) {
					macc.clickLogout();
					Assert.assertTrue(false);

				} else {
					Assert.assertTrue(true);

				}
			}

		} catch (Exception e) {
			Assert.fail();
		}
		Thread.sleep(3000);
		logger.info("*** finished TC003_LoginDDT ***");
	}

}
