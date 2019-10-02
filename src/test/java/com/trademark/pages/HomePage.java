package com.trademark.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trademark.utils.BaseClass;

public class HomePage extends BaseClass {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "button[class^=\"defaultSearch\"]")
	public WebElement defaultsFilter;

	@FindBy(xpath = "//div[@id='tableControls']//span[@class='pageCount ng-binding']")
	public WebElement recordsCount;

	@FindBy(xpath = "//div[@class='filterGroup publicPublished']//div[@class='fiveRecent']/div/label/input")
	public List<WebElement> issuesList;

	@FindBy(css = "input[class^='pubReasonOpposition']")
	public WebElement opposition;
	@FindBy(css = "input[class^='registrations']")
	public WebElement registrations;
	@FindBy(xpath = "//div[@id=\"pubReasonDelegate\"]//div[@class=\"checkbox submenuTitle\"]/label/input")
	public WebElement registrationCancelled;

	@FindBy(xpath = "//div[@class=\"sidebarGroup\"][4]//div[@class=\"checkbox-inline submenuTitle\"]/label/input")
	public WebElement internationalClass;

	@FindBy(xpath = "//div[@class=\"sidebarGroup\"][4]//div[@class=\"checkbox submenuTitle\"]/label/input")
	public WebElement usClass;

	@FindBy(xpath = "//div[@id='sidebarDelegate']//div[@class=\"sidebarGroup\"][3]/div/div/label/input")
	public List<WebElement> reasonForPublication;

	@FindBy(xpath = "//div[@id='sidebarDelegate']//div[@class=\"sidebarGroup\"][4]/div/div/label/input")
	public List<WebElement> classNumbers;

	@FindBy(xpath = "//div[@id='sidebarDelegate']//div[@class=\"sidebarGroup\"][5]/div/div/label/input")
	public List<WebElement> register;

	@FindBy(xpath = "//div[@id='sidebarDelegate']//div[@class=\"sidebarGroup\"][6]/div/div/label/input")
	public List<WebElement> numberOfclasses;

	@FindBy(xpath = "//div[@id='sidebarDelegate']//div[@class=\"sidebarGroup\"][7]/div/div/label/input")
	public List<WebElement> markType;

	@FindBy(xpath = "//div[@id='sidebarDelegate']//div[@class=\"sidebarGroup\"][8]/div/div/label/input")
	public List<WebElement> basisList;

	@FindBy(xpath = "//*[@class=\"container-fluid\"]//*[@class=\"row noResultTile\"]/div/h3")
	public WebElement noRecordFound;
	
	
	@FindBy(xpath="//span[contains(text(),'Serial Number:')]")
	public WebElement serialNumber;
	

	

}
