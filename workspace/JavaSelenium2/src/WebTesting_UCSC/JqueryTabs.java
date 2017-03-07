package WebTesting_UCSC;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class JqueryTabs {
	private WebElement jQueryTabs;
	
	public JqueryTabs(WebElement jtabs) {
		jQueryTabs = jtabs;
	}
	
	public int getTabCount() {
		List<WebElement> tabs = jQueryTabs.findElements(By.cssSelector(".ui-tabs-nav > li"));
		return tabs.size();
	}
	
	public String getSelectedTabTitle() {
		WebElement selected = jQueryTabs.findElement(By.cssSelector(".ui-tabs-nav > li[class *= 'ui-tabs-active'"));
		return selected.getText();
	}
	
	public WebElement getSelectedTabContent() {
		List<WebElement> panels = jQueryTabs.findElements(By.cssSelector(".ui-tabs-panel"));
		for (WebElement panel: panels) {
			if (panel.getCssValue("display").equals("block")) {
				return panel;
			}
		}
		return null;
	}
	
	public void selectTabByIndex(int index) {
		List<WebElement> tabs = jQueryTabs.findElements(By.cssSelector(".ui-tabs-nav > li"));
		tabs.get(index).click();
	}
	
	public void selectTabByTitle(String title) {
		List<WebElement> tabs = jQueryTabs.findElements(By.cssSelector(".ui-tabs-nav > li"));
		for (WebElement tab : tabs) {
			if (tab.getText().equals(title)) {
				tab.click();
				return;
			}
		}
	}
}
