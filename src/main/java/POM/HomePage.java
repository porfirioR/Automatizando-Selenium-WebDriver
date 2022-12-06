package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyReader;

public class HomePage extends BasePage {

    private final By inputFormBy = By.linkText("Input Forms");
    private final By inputFormSubmitBy = By.linkText("Input Forms Submit");
    private final String homePage = PropertyReader.getEnvironment("home_page");
    private final String homePageTitle = PropertyReader.getEnvironment("home_page_title");
    public HomePage(WebDriver webDriver) {
        super(webDriver);
        webDriver.get(homePage);
        try {
            if (!getTitle().equals(homePageTitle)) {
                throw new Exception("La pagina no es la esperada.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public InputFormDemoPage accessInputFormDemo() {
        click(inputFormBy);
        click(inputFormSubmitBy);
        /*
         this.webDriver.findElement(inputFormBy).click();
         this.webDriver.findElement(inputFormSubmitBy).click();
        */
        return new InputFormDemoPage(webDriver);
    }
}
