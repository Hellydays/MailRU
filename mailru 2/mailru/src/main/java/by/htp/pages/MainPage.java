package by.htp.pages;

import javax.naming.OperationNotSupportedException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {
	
	@FindBy(linkText = "Написать письмо")
	private WebElement newEmailBtn;
	
	@FindBy(css = "textarea[data-original-name=\"To\"]")
	private WebElement toField;
	
	@FindBy(xpath = "//iframe[@id[contains(.,'toolkit')]]")
	private WebElement frame;
	
	@FindBy(id = "tinymce")
	private WebElement textField;
	
	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() throws OperationNotSupportedException {
		throw new OperationNotSupportedException("Not allowed");
	}
	
	public void createNewEmail() {
		newEmailBtn.click();
	}
	
	public void createNewEmail(String to, String text) {
		
		newEmailBtn.click();
		toField.sendKeys(to);
			
		driver.switchTo().frame(frame);
		
		textField.click();
		textField.sendKeys(text);
	}

}
