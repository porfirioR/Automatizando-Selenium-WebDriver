package pom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver webDriver;

    protected BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    protected void Click(By element) {
        webDriver.findElement(element).click();
    }

    protected void SenKeys(By element, String text) {
        webDriver.findElement(element).clear();
        webDriver.findElement(element).sendKeys(text);
    }

    protected String GetTitle() {
        return webDriver.getTitle();
    }

    protected void Quit() {
        webDriver.quit();
    }
}