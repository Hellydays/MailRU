package by.htp.pages;

import javax.naming.OperationNotSupportedException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage {
	
	@FindBy(linkText = "Написать письмо")
	private WebElement newEmailBtn;
	
	@FindBy(css = "textarea[data-original-name=\"To\"]")
	private WebElement toField;
	
	@FindBy(css = "input[name=\"Subject\"]")
	private WebElement topicField;
	
	@FindBy(xpath = "//iframe[@id[contains(.,'toolkit')]]")
	private WebElement composeFrame;
	
//	@FindBy(id = "tinymce")
	@FindBy(xpath = "//body[@id = 'tinymce' and @class = 'mceContentBody compose2']")
	private WebElement textField;
	
//	@FindBy(linkText = "Отправить")
	@FindBy(xpath="//*[@id='b-toolbar__right']/div[3]/div/div[2]/div[1]/div/span")
	private WebElement sendBtn;
	
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
	
	public void createNewEmail(String to, String topic, String text) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(newEmailBtn));
		newEmailBtn.click();
		toField.sendKeys(to);
		
		topicField.click();
		topicField.sendKeys(topic);
		
		driver.switchTo().frame(composeFrame);
		
		textField.click();
		textField.clear();
		textField.sendKeys(text);
		
		driver.switchTo().parentFrame();
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(sendBtn));
		sendBtn.click();
//		driver.findElement(By.xpath("//body[@id = 'tinymce' and @class = 'mceContentBody compose2']")).sendKeys(text);
		driver.switchTo().defaultContent();
		
	}

}
