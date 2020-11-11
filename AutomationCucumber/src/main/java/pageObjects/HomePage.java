package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;
import managers.FileReaderManager;
import selenium.Wait;

public class HomePage {
	@FindBy(id="from.text")
	private WebElement fromSource;
	@FindBy(id="to.text")
	private WebElement toDest;
	@FindBy(xpath="//input[@id='viaAvoidStation.text']")
	private WebElement viaRoute;
	@FindBy(xpath="//span[contains(text(),'Via')]")
	private WebElement route;
	@FindBy(xpath="//input[@id='single']")
	private WebElement oneWay;
	@FindBy(xpath="//input[@id='return']")
	private WebElement roundTrip;
	@FindBy(xpath="//input[contains(@id,'page.journeySearchForm.outbound.title')]")
	private WebElement outDate;
	@FindBy(xpath="//button[contains(@type,'submit')]")
	private WebElement getTicket;
	@FindBy(xpath="//div[@role='alert']//span")
	private List<WebElement> msgError;
	@FindBy(xpath = "//div[@data-test='eu-matrix-date']/span/span[2]")
	private WebElement dateLabel;
	@FindBy(xpath = "//div[@data-test='eu-journey-row-0']/div/div/span[1]")
	private WebElement timeLabel;
	@FindBy(xpath = "//div[@data-test='eu-journey-row-0-first-class-ticket-price']/span[1]")
	private WebElement priceLabel;
	
	WebDriver driver;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	public void navigateTo_HomePage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}
	
	public void enter_Value(String station, String stationName) {
		switch(station.toLowerCase().trim()){
		case "from":
			fromSource.sendKeys(stationName);
			fromSource.sendKeys(Keys.TAB);
			Wait.untilJqueryIsDone(driver);
			break;
		case "to":
			toDest.sendKeys(stationName);
			toDest.sendKeys(Keys.TAB);
			Wait.untilJqueryIsDone(driver);
			break;
		case "avoid":	
		case "via":
			viaRoute.sendKeys(stationName);
			viaRoute.sendKeys(Keys.TAB);
			Wait.untilJqueryIsDone(driver);
			break;
		case "outdate":
			outDate.clear();
			outDate.sendKeys(stationName);
			outDate.sendKeys(Keys.TAB);
			Wait.untilJqueryIsDone(driver);
			break;
		case "leaving at hour":
			WebElement hour = driver.findElement(By.xpath("//div[@class='_1uztl9uNaN']//select[@name='hours']"));
			Select sel = new Select(hour);
			sel.selectByValue(stationName);
			Wait.untilJqueryIsDone(driver);
			break;
		case "leaving at min":
			WebElement min = driver.findElement(By.xpath("//div[@class='_1uztl9uNaN']//select[@name='minutes']"));
			Select sel_min = new Select(min);
			sel_min.selectByValue(stationName);
			Wait.untilJqueryIsDone(driver);
			break;
		default:
			Assert.assertTrue("Under source/destination field is incorrect", false);
		}
	}
	
	public void clickOnControl(String clickOn) {
		switch(clickOn.toLowerCase().trim()) {
		case "via/avoid":
			route.click();
			Wait.untilJqueryIsDone(driver);
			break;
		case "one way":
			if(oneWay.isSelected()) {
				System.out.println("Already selected");
			}else {
			oneWay.click();
			Wait.untilJqueryIsDone(driver);
			}
			break;
		case "return":
			if(roundTrip.isSelected()) {
				System.out.println("Already selected");
			}else {
				roundTrip.click();
			Wait.untilJqueryIsDone(driver);
			}
			break;
		case "get ticket":
			((JavascriptExecutor) driver)
		     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
			getTicket.click();
			Wait.untilJqueryIsDone(driver);
			break;
		default:
			Assert.assertTrue("selected control not found", false);
			break;
		}
		
	}
	
	public void validateMsg(String expected) {
		Assert.assertEquals(expected.trim(), msgError.get(0).getText().trim());
	}
	public void validateDate(String date) {
		Assert.assertEquals(date.trim(), dateLabel.getText().trim());
	}
	public void validateTime(String time) {
		Assert.assertEquals(time.trim(), timeLabel.getText().trim());
	}
	public void validatePrice(String price) {
		Assert.assertEquals(price.trim(), priceLabel.getText().trim());
	}

}