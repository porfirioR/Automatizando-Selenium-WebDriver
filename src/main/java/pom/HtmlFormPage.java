package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.PropertyReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HtmlFormPage extends BasePage {
    private By userNameBy;
    private By passwordBy;
    private By textAreaCommentBy;
    private By multipleSelectBy;
    private By dropdownBy;
    private By checkboxItemBy;
    private By btnSubmit;
    private By formResultsBy;

    public HtmlFormPage(WebDriver webDriver) {
        super(webDriver);

        try {
            if (!GetTitle().equals(PropertyReader.getEnvironment("html_form_title"))) {
                throw new Exception("La pagina no es la esperada.");
            }

            userNameBy = By.name("username");
            passwordBy = By.name("password");
            textAreaCommentBy = By.name("comments");
            checkboxItemBy = By.name("checkboxes[]");
            multipleSelectBy = By.name("multipleselect[]");
            dropdownBy = By.name("dropdown");
            btnSubmit = By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[9]/td/input[2]");
            formResultsBy = By.className("form-results");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //endregion

    public void InsertUserName(String userName) {
        SenKeys(userNameBy, userName);
    }

    public void InsertPassword(String password) {
        SenKeys(passwordBy, password);
    }

    public void InsertComment(String comment) {
        SenKeys(textAreaCommentBy, comment);
    }

    public void ClickCheckButton(String option) {
        for (WebElement checkBox : webDriver.findElements(checkboxItemBy)) {
            String checkBoxOption = checkBox.getAttribute("value");
            if (checkBoxOption.equals(option)) {
                checkBox.click();
            }
        }
    }

    public void ClickMultiselectByOption(String option) {
        WebElement selectTag = webDriver.findElement(multipleSelectBy);
        Select select = new Select(selectTag);
        for (WebElement selectOption : select.getOptions()) {
            if (selectOption.getAttribute("value").contains(option)) {
                selectOption.click();
            }
        }
    }

    public void SelectDropdownByOption(String option) {
        WebElement dropdownTag = webDriver.findElement(dropdownBy);
        Select select = new Select(dropdownTag);
        for (WebElement selectOption : select.getOptions()) {
            if (selectOption.getAttribute("value").contains(option)) {
                selectOption.click();
            }
        }
    }

    public void ClickSubmit() {
        Click(btnSubmit);
    }

    public WebElement GetFormResults() {
        return webDriver.findElement(formResultsBy);
    }

    public boolean CheckInvalid(WebElement formResults, String[] inputValues) {
        boolean invalid = false;
        List<String> codes = new ArrayList<String>();
        codes.add("_valueusername");
        codes.add("_valuepassword");
        codes.add("_valuecomments");
        codes.add("_valuecheckboxes0");
        codes.add("_valuemultipleselect0");
        codes.add("_valuedropdown");

        for (String code : codes) {
            WebElement webElement = formResults.findElement(By.id(code));
            String value = webElement.getText();
            if (!Arrays.stream(inputValues).anyMatch(value::equals)) {
                invalid = true;
            }
        }

        return invalid;
    }

    public String GetCurrentPageTitle() {
        return GetTitle();
    }

    public void ClosePage() {
        Quit();
    }

}
