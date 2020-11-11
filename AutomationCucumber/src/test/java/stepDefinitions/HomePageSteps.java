package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import pageObjects.HomePage;

public class HomePageSteps {
	TestContext testContext;
	HomePage homePage;
	

	public HomePageSteps(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		
	}

	@Given("^user is on Home Page$")
	public void user_is_on_Home_Page() {
		homePage.navigateTo_HomePage();
	}
	@And("^enter \"([^\"]*)\" value \"([^\"]*)\" on Home Page$")
	public void enter_Value(String station, String stationName) {
		homePage.enter_Value(station, stationName);
	}
	@And("^click on \"([^\"]*)\" on Home Page$")
		public void clickOnControl(String route) {
			homePage.clickOnControl((route));
		}
	@And("^verify the error message value \"([^\"]*)\" on Home Page$")
	public void validate_msg(String errorMsg) {
		homePage.validateMsg(errorMsg);
	}
	@And("^Verify \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\" on Home Page$")
	public void verify_and_on_Home_Page(String date, String time, String price) {
		homePage.validateDate(date);
		homePage.validateTime(time);
		homePage.validatePrice(price);
	}
	
	

}
