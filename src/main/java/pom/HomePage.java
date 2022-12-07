package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyReader;

public class HomePage extends BasePage {
    private final By inputFormsBy = By.linkText("Input Forms");
    private final By inputFormSubmitBy = By.linkText("Input Form Submit");
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
        click(inputFormsBy);
        click(inputFormSubmitBy);
        return new InputFormDemoPage(webDriver);
    }
}
