package uk.co.library.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.co.library.utility.Utility;

public class HomePage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());
    @CacheLookup
    @FindBy(xpath = "//input[@id='keywords']")
    WebElement jobTitleField;
    @CacheLookup
    @FindBy(xpath = "//input[@id='location']")
    WebElement locationField;
    @CacheLookup
    @FindBy(xpath = "//select[@id='distance']")
    WebElement distanceDropDown;
    @CacheLookup
    @FindBy(xpath = "//button[@id='toggle-hp-search']")
    WebElement moreSearchOptionsLink;
    @CacheLookup
    @FindBy(xpath = "//input[@id='salarymin']")
    WebElement salaryMin;
    @CacheLookup
    @FindBy(xpath = "//input[@id='salarymax']")
    WebElement salaryMax;
    @CacheLookup
    @FindBy(xpath = "//select[@id='salarytype']")
    WebElement salaryTypeDropDown;
    @CacheLookup
    @FindBy(xpath = "//select[@id='tempperm']")
    WebElement jobTypeDropDown;
    @CacheLookup
    @FindBy(xpath = "//input[@id='hp-search-btn']")
    WebElement findJobsButton;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void switchToIframe() {
        driver.switchTo().frame("gdpr-consent-notice");
        clickOnElement(By.xpath("//div[@class='action-buttons top-bottom right-column ng-star-inserted']/button[2]"));
        driver.switchTo().defaultContent();
    }

    public void enterJobTitle(String jobTitle) {
        log.info("EnterJob Title" + jobTitle + "to job title field " + jobTitleField.toString());
        sendTextToElement(jobTitleField, jobTitle);
    }

    public void enterLocation(String location) {
        log.info("Enter location" + location + "to location field " + locationField.toString());
        sendTextToElement(locationField, location);
    }

    public void selectDistance(String distance) {
        log.info("Select Distance " + distance + "from distance field " + distanceDropDown.toString());
        sendTextToElement(distanceDropDown, distance);
    }

    public void clickOnMoreSearchOptionLink() {
        log.info("Click on search option link" + moreSearchOptionsLink.toString());
        clickOnElement(moreSearchOptionsLink);
    }

    public void enterMinSalary(String minSalary) {
        log.info("Enter min salary " + minSalary + "to salary field " + salaryMin.toString());
        sendTextToElement(salaryMin, minSalary);
    }

    public void enterMaxSalary(String maxSalary) {
        log.info("Enter Max salary" + maxSalary + "to salary field " + salaryMax.toString());
        sendTextToElement(salaryMax, maxSalary);
    }

    public void selectSalaryType(String salaryType) {
        log.info("Select salary type" + salaryType + "from dropdown " + salaryTypeDropDown.toString());
        selectByVisibleTextFromDropDown(salaryTypeDropDown, salaryType);
    }

    public void selectJobType(String jobType) {
        log.info("Select job type " + jobType + "from dropdown " + jobTypeDropDown.toString());
        sendTextToElement(jobTypeDropDown, jobType);
    }

    public void clickOnFindJobsButton() {
        log.info("Click on find jobs button " + findJobsButton.toString());
        clickOnElement(findJobsButton);
    }
}

