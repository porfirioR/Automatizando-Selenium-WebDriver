package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputFormDemoPage extends BasePage {
    private By firstNameBy;
    private By lastNameBy;
    private By emailBy;
    private By phoneBy;
    private By addressBy;
    private By cityBy;
    private By stateBy;
    private By zipBy;
    private By webSiteBy;
    private By commentBy;
    private By btnSend;
    private By alertSmall;

    public InputFormDemoPage(WebDriver webDriver) {
        super(webDriver);

        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
