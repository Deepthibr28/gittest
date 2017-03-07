package WebTesting_UCSC;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class WebTable {
	private WebElement table;
	
	public WebTable(WebElement table) {
		this.table = table;
	}
	
	public int getRowCount() {
		List<WebElement> rows = table.findElements(By.xpath(".//tr/td/.."));
		return rows.size();
	}
	
	public int getColumnCount() {
		WebElement firstRow = table.findElement(By.xpath(".//td/.."));
		List<WebElement> cells = firstRow.findElements(By.tagName("td"));
		return cells.size();
	}
	
	public boolean hasHeader() {
		try {
			table.findElement(By.cssSelector("tr > th"));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public String getCellData(int row, int col) {
		WebElement currCell = table.findElement(By.xpath("(.//tr/td/..)[" + row + "]"))
				.findElement(By.cssSelector("td:nth-child(" + col + ")"));
		return currCell.getText();
	}
	
	public WebElement getCellElement(int row, int col) {
		WebElement currCell = table.findElement(By.xpath("(.//tr/td/..)[" + row + "]"))
				.findElement(By.cssSelector("td:nth-child(" + col + ")"));
		return currCell.findElement(By.xpath("./*"));
	}
}
