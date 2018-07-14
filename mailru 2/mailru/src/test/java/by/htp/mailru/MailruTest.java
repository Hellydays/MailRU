package by.htp.mailru;

import javax.naming.OperationNotSupportedException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.htp.pages.LoginPage;
import by.htp.pages.MainPage;

public class MailruTest {
	
	private static final String CHROME = "webdriver.chrome.driver";
	private static final String CHROME_PATH = "/Users/qauser/Documents/chromedriver";
	
	private WebDriver driver;
	private String login = "tathtp";
	private String password = "Klopik123";
	private String to = "tomwhite43434@gmail.com";
	private String text = "Hello World!";
	
	@BeforeTest
	public void initDriver() {
		System.setProperty(CHROME, CHROME_PATH);
		driver = new ChromeDriver();
	}
	
	@AfterTest
	public void finish() {
		driver.quit();
	}
	
	@Test
	public void authTest() {
		LoginPage loginPage = new LoginPage(driver); 
		MainPage mainPage = new MainPage(driver);
		try {
			loginPage.openPage();
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginPage.login(login, password);
		mainPage.createNewEmail(to, text);
		
	}
	

}
