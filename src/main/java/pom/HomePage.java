package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyReader;

public class HomePage extends BasePage {
    private final By htmlFormExample = By.linkText("HTML Form Example");
    private final String homePage = PropertyReader.getEnvironment("home_page");
    public HomePage(WebDriver webDriver) {
        super(webDriver);
        webDriver.get(homePage);
        click(htmlFormExample);
    }

    public HtmlFormPage accessHtmlFormExample() {
        return new HtmlFormPage(webDriver);
    }
}
