package com.trademark.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.annotations.Until;
import com.trademark.pages.CaseDetailsPage;
import com.trademark.pages.HomePage;
import com.trademark.utils.CommonMethods;
import com.trademark.utils.Constant;

public class HomePageTest extends CommonMethods {

	public HomePage h;
	public CaseDetailsPage c;

	@Test(groups = "smoke")
	public void homePageOne() throws InterruptedException {

		h = new HomePage();

		waitForElementBeClickable(h.defaultsFilter, 15);
		h.defaultsFilter.click();

		waitForElementBeClickable(h.opposition, 15);

		if (h.opposition.isSelected()) {
			h.opposition.click();
		}

		new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfAllElements(h.reasonForPublication));
		List<WebElement> reasonList = h.reasonForPublication;
		for (WebElement run : reasonList) {
			if (run.isSelected()) {
				run.click();
			}
		}

		new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfAllElements(h.classNumbers));
		List<WebElement> clussNumberList = h.classNumbers;
		for (WebElement run : clussNumberList) {
			if (run.isSelected()) {
				run.click();
			}
		}

		new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfAllElements(h.register));
		List<WebElement> registerList = h.register;
		for (WebElement run : registerList) {
			if (run.isSelected()) {
				run.click();
			}
		}

		new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfAllElements(h.numberOfclasses));
		List<WebElement> numberOfclasseslist = h.numberOfclasses;
		for (WebElement run : numberOfclasseslist) {
			if (run.isSelected()) {
				run.click();
			}
		}

		new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfAllElements(h.markType));
		List<WebElement> markTypeList = h.markType;
		for (WebElement run : markTypeList) {
			if (run.isSelected()) {
				run.click();
			}
		}

		new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfAllElements(h.basisList));
		List<WebElement> basis = h.basisList;

		for (int i = 1; i < basis.size() - 1; i++) {

			if (basis.get(i).isSelected()) {
				basis.get(i).click();
			}

		}
		basis.get(4).click();

		new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfAllElements(h.issuesList));
		List<WebElement> issueList = h.issuesList;

		String records = h.recordsCount.getText();

		for (int i = 1; i < issueList.size(); i++) {

			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(h.recordsCount));

			records = h.recordsCount.getText();
			
			Thread.sleep(100);

			if (!records.equals("0")) {
				break;

			} else {
				issueList.get(i).click();
			}

		}
		

		try {

			new WebDriverWait(driver,3).until(ExpectedConditions.visibilityOf(h.serialNumber));
			Actions action=new Actions(driver);
			action.moveToElement(h.serialNumber).click().perform();
			
			

		} catch (Exception ex) {
			ex.getStackTrace();
		}

		try {
			
			c=new CaseDetailsPage();
			
			new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(c.basisInformation));
			//System.out.println(c.basisInformation.getText());
			String actual=c.basisInformation.getText();
			String expected="44(d), filed 44d, filed itu, 1(a)";
			
			
			
			Assert.assertEquals(actual, expected);

		} catch (Exception ex) {
			ex.getStackTrace();
		}

		

	}

}
