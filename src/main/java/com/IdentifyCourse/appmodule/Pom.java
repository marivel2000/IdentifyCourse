package com.IdentifyCourse.appmodule;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Pom extends DriverSetup{

	private static WebElement element=null;
	static List<WebElement> elements = null;

	public Pom(WebDriver driver, WebElement element) {
		super();
	}

	/***********Fetching the xpath for Search courses*********/
	static By coursename=By.xpath("//*[contains(@placeholder,'W')]");
	static By coursenameclick=By.xpath("//button[2]/div");
	public static By lang=By.id("react-select-2--value");
	static By langclick=By.id("react-select-2--option-0");
	public static By level=By.id("react-select-3--value");
	static By levelclick=By.id("react-select-3--option-0");
	public static By learning=By.id("react-select-8--value");
	static By learningclick=By.id("react-select-8--option-1");
	static By firstcoursename = By.xpath("//ul[@class='ais-InfiniteHits-list']/li[1]//h2");
	static By secondcoursename =By.xpath("//ul[@class='ais-InfiniteHits-list']/li[2]//h2");
	static By firstreview =By.xpath("//ul[@class='ais-InfiniteHits-list']/li[1]//span[@class='ratings-text']");
	static By secondreview = By.xpath("//ul[@class='ais-InfiniteHits-list']/li[2]//span[@class='ratings-text']");
	static By button1=By.xpath("//ul[@class='ais-InfiniteHits-list']/li[1]//h2");
	static By button2=By.xpath("//ul[@class='ais-InfiniteHits-list']/li[2]//h2");
	static By firstduration=By.xpath("//div[@class='ProductGlance']/div[5]//span");
	static By secondduration=By.xpath("//div[@class='ProductGlance']/div[6]//span");
			
	/***********Fetching the xpath for Language learning*********/
	static By searchBar=By.xpath("//*[contains(@placeholder,'W')]");
	public static By languageBtn=By.xpath("//*[contains(@class,'Select-pl') and contains(text(),'La')]");
	static By showAllButton=By.xpath("//*[contains(text(),'Show All')]");
	static By allTextLang=By.xpath("//div[@class='filters-modal-content horizontal-box']");
	static By closeBtn=By.xpath("//a[@class='nostyle']");
	public static By levelsBtn=By.xpath("//div[@id='react-select-3--value']");
	public static By allLevels=By.xpath("//div[@id='react-select-3--list']/div");
	
	/***********Fetching the xpath for Form filling*********/
	static By enterprise = By.id("enterprise-link");
	static By products = By.xpath("//a[text()='Products']");
	static By forcampus = By.xpath("//a[text()='For Campus' and @rel='noopener']");
	static By transform = By.xpath("//h2[contains(text(),'Ready to transform your campus?')]");
	static By firstName = By.xpath("//*[@id='FirstName']");
    static By lastName = By.xpath("//*[@id='LastName']");
    static By jobFunction = By.xpath("//*[@id='C4C_Job_Title__c']");
    static By jobTitle = By.xpath("//*[@id='Title']");
    static By mail = By.xpath("//*[@id='Email']");
    static By Phone = By.xpath("//*[@id='Phone']");
    static By Company = By.xpath("//*[@id='Company']");
    static By institutionType = By.xpath("//*[@id='Institution_Type__c']");
    static By primaryDiscipline = By.xpath("//*[@id='Primary_Discipline__c']");
    static By Country = By.xpath("//*[@id='Country']");
    static By help=By.xpath("//*[@id='What_the_lead_asked_for_on_the_website__c']");
    static By submitButton = By.xpath("//*[@id='mktoForm_1512']/div[20]/span/button");
    static By email=By.id("ValidMsgEmail");
    static By state=By.id("State");
    

    
	public static WebElement getState() {
		element=driver.findElement(state);
		return element;
	}
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
	public static WebElement getFirstcoursename() {
		element=driver.findElement(firstcoursename);
		return element;
	}
	public static WebElement getSecondcoursename() {
		element=driver.findElement(secondcoursename);
		return element;
	}
	public static WebElement getFirstreview() {
		element=driver.findElement(firstreview);
		return element;
		
	}
	public static WebElement getSecondreview() {
		element=driver.findElement(secondreview);
		return element;
	}
	public static WebElement getButton1() {
		element=driver.findElement(button1);
		return element;
		
	}
	public static WebElement getButton2() {
		element=driver.findElement(button2);
		return element;
	}
	public static WebElement getFirstduration() {
		element=driver.findElement(firstduration);
		return element;
	}
	public static WebElement getSecondduration() {
		element=driver.findElement(secondduration);
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
