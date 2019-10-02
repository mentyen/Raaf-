package com.trademark.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.trademark.utils.BaseClass;

public class CaseDetailsPage extends BaseClass {
	
	
	public WebElement basisInformation=driver.findElement(By.xpath("//div[@ng-show=\"good.classFilingBasises[0]\"]/p"));

}
