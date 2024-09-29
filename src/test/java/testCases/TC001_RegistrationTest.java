package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_RegistrationTest extends BaseClass {

	@Test(groups = {"Regression","Master"})
	public void verify_account_registration() {
		logger.info("*** Starting TC001_RegistrationTest ***");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount Link");
			hp.clickRegister();
			logger.info("Clicked on Register Link");

			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
			logger.info("Providing customer details...");
			regpage.setFirstName(randomString().toUpperCase());// random generated fast name
			regpage.setLastName(randomString().toUpperCase());// random generated last name
			regpage.setEmail(randomString() + "@gmail.com");// random generated email
			regpage.setTelephone(randomNumber());

			String password = randomAlphaNumberic(); // calling one time so that kept it in password
			regpage.setPassWord(password); // random generated one time password in
			regpage.setConformPwd(password); // both (password & confirm password)

			regpage.setPrivacyPolicy();
			regpage.setContinue();

			logger.info("validating expected massege...");
			String confmsg = regpage.getConfirmationMsg();
//			Assert.assertEquals(confmsg, "Your Account Has Been Created!");
			if (confmsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			} else {
				logger.error("Test failed...");
				logger.debug("Debug logs..");
				Assert.assertTrue(false);
			}
//			Assert.assertEquals(confmsg, "Your Account Has Been Created!!!");

		} catch (

		Exception e) {
//			logger.error("Test failed...");
//			logger.debug("Debug logs..");
			Assert.fail();
		}
		logger.info("*** Finished TC001_RegistrationTest ***");

	}

}
