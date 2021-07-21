package com.IdentifyCourse.appmodule;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class Pom extends DriverSetup{

	public Pom(WebDriver driver, WebElement element) {
		super();
	}
	static By coursename=By.xpath("//*[contains(@placeholder,'W')]");
	static By coursenameclick=By.xpath("//*[@id=\"__next\"]/header/div/div/div/div[1]/div[3]/div/form/div/div/div[1]/button[2]/div");
	
	static By lang=By.id("react-select-2--value");
	static By langclick=By.id("react-select-2--option-0");
	
	static By level=By.id("react-select-3--value");
	static By levelclick=By.id("react-select-3--option-0");
	
	static By learning=By.id("react-select-8--value");
	static By learningclick=By.id("react-select-8--option-1");
	
	
	
	private static WebElement element=null;
	
	static By searchBar=By.xpath("//*[contains(@placeholder,'W')]");
	static By languageBtn=By.xpath("//*[contains(@class,'Select-pl') and contains(text(),'La')]");
	static By showAllButton=By.xpath("//*[contains(text(),'Show All')]");
	static By allTextLang=By.xpath("//div[@class='filters-modal-content horizontal-box']");
	static By closeBtn=By.xpath("//a[@class='nostyle']");
	static By levelsBtn=By.xpath("//div[@id='react-select-3--value']");
	static By allLevels=By.xpath("//div[@id='react-select-3--list']/div");
	
	
	
	static List<WebElement> elements = null;

	static By enterprise = By.id("enterprise-link");
	static By products = By.xpath("//a[text()='Products']");
	static By forcampus = By.xpath("//a[text()='For Campus' and @rel='noopener']");
	static By transform = By.xpath("//h2[contains(text(),'Ready to transform your campus?')]");
	static By firstName = By.xpath("//*[@id='FirstName']");
    static By lastName = By.xpath("//*[@id=\"LastName\"]");
    static By jobFunction = By.xpath("//*[@id='C4C_Job_Title__c']");
    static By jobTitle = By.xpath("//*[@id=\"Title\"]");
    static By mail = By.xpath("//*[@id=\"Email\"]");
    static By Phone = By.xpath("//*[@id=\"Phone\"]");
    static By Company = By.xpath("//*[@id=\"Company\"]");
    static By institutionType = By.xpath("//*[@id=\"Institution_Type__c\"]");
    static By primaryDiscipline = By.xpath("//*[@id=\"Primary_Discipline__c\"]");
    static By Country = By.xpath("//*[@id=\"Country\"]");
    static By help=By.xpath("//*[@id=\"What_the_lead_asked_for_on_the_website__c\"]");
    static By submitButton = By.xpath("//*[@id=\"mktoForm_1512\"]/div[20]/span/button");
    static By email=By.id("ValidMsgEmail");
	public static WebElement getCoursename() {
		element=driver.findElement(coursename);
		return element;
	}
	public static WebElement getCoursenameclick() {
		element=driver.findElement(coursenameclick);
		return element;
	}
	public static WebElement getLang() {
		element=driver.findElement(lang);
		return element;
	}
	public static WebElement getLangclick() {
		element=driver.findElement(langclick);
		return element;
	}
	public static WebElement getLevel() {
		element=driver.findElement(level);
		return element;
	}
	public static WebElement getLevelclick() {
		element=driver.findElement(levelclick);
		return element;
	}
	public static WebElement getLearning() {
		element=driver.findElement(learning);
		return element;
	}
	public static WebElement getLearningclick() {
		element=driver.findElement(learningclick);
		return element;
	}

	
	public static WebElement searchBar() {
		element=driver.findElement(searchBar);
		return element;
	}
	public static WebElement languageBtn() {
		element=driver.findElement(languageBtn);
		return element;
	}
	public static WebElement showAllButton() {
		element=driver.findElement(showAllButton);
		return element;
	}
	public static WebElement allTextLang() {
		element=driver.findElement(allTextLang);
		return element;
	}
	public static WebElement closeBtn() {
		element=driver.findElement(closeBtn);
		return element;
	}
	public static WebElement levelsBtn() {
		element=driver.findElement(levelsBtn);
		return element;
	}
	public static List<WebElement> allLevels() {
		elements=driver.findElements(allLevels);
		return elements;
	}
	
	
	public static WebElement enterprise() {
		element = driver.findElement(enterprise);
		return element;
	}

	public static WebElement products() {
		element = driver.findElement(products);
		return element;
	}

	public static WebElement forcampus() {
		element = driver.findElement(forcampus);
		return element;
	}

	public static WebElement transform() {
		element = driver.findElement(transform);
		return element;
	}

	public static WebElement firstName() {
		element = driver.findElement(firstName);
		return element;
	}

	public static WebElement lastName() {
		element = driver.findElement(lastName);
		return element;
	}

	public static WebElement jobFunction() {
		element = driver.findElement(jobFunction);
		return element;
	}

	public static WebElement jobTitle() {
		element = driver.findElement(jobTitle);
		return element;
	}
	
	public static WebElement mail() {
		element = driver.findElement(mail);
		return element;
	}

	public static WebElement Phone() {
		element = driver.findElement(Phone);
		return element;
	}

	public static WebElement Company() {
		element = driver.findElement(Company);
		return element;
	}

	public static WebElement institutionType() {
		element = driver.findElement(institutionType);
		return element;
	}

	public static WebElement primaryDiscipline() {
		element = driver.findElement(primaryDiscipline);
		return element;
	}

	public static WebElement Country() {
		element = driver.findElement(Country);
	    return element;
	}

	public static WebElement help() {
		element = driver.findElement(help);
		return element;
	}
	public static WebElement submitButton() {
		element = driver.findElement(submitButton);
		return element;
	}
	public static WebElement email() {
		element = driver.findElement(email);
		return element;
	}

	

}
