package by.htp.pages;

import javax.naming.OperationNotSupportedException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {
	
	private final String BASE_URL = "https://mail.ru";
	
	@FindBy(id = "mailbox:login")
	private WebElement loginField;
	
	@FindBy(id = "mailbox:password")
	private WebElement passwordField;
	
	@FindBy(css = "input.o-control")
	private WebElement submitButton;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() throws OperationNotSupportedException {
		driver.navigate().to(BASE_URL);
		driver.manage().window().maximize();
		
	}
	
	public void login(String username, String password) {
		
		loginField.click();
		loginField.sendKeys(username);
		
		passwordField.click();
		passwordField.sendKeys(password);
		
		submitButton.click();
	}

	

}
