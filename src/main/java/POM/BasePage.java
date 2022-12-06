package POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class BasePage {
    protected WebDriver webDriver;

    protected BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    protected void sendKeys(By element, String text) {
        webDriver.findElement(element).sendKeys(text);
    }

    protected void click(By element) {
        webDriver.findElement(element).click();
    }

    protected void quit() {
        webDriver.quit();
    }
}