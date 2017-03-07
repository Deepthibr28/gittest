package WebTesting_UCSC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BootstrapDialog {
	private WebElement dialog;
	
	public BootstrapDialog(WebElement dialog) {
		this.dialog = dialog;
	}
	
	public String getTitle() {
		return dialog.findElement(By.className("modal-title")).getText();
	}
	
	public String getBodyText() {
		return dialog.findElement(By.className("modal-body")).getText();
	}
	
	public void closeByIcon() {
		WebElement btn = dialog.findElement(By.cssSelector(".modal-header > button.close"));
		btn.click();		
	}
	
	public WebElement getDialog() {
		return dialog;
	}
}
