package pom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

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
    protected void senKeys(By element, String text) {
        webDriver.findElement(element).sendKeys(text);
    }
    protected void selectByVisibleText(By element, String text) {
        new Select(webDriver.findElement(element)).selectByVisibleText(text);
    }

    protected String getTitle() {
        return webDriver.getTitle();
    }

    protected void quit() {
        webDriver.quit();
    }
}