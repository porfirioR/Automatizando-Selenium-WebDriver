import org.openqa.selenium.WebElement;
import pom.HomePage;
import pom.HtmlFormPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import utils.Utils;

public class TestHtmlForm {
    private WebDriver webDriver;
    private HtmlFormPage htmlFormPage;
    private static  String USERNAME;
    private static String PASSWORD;
    private static String COMMENT;
    private static String CHECKBOXITEM;
    private static String MULTIPLESELECT;
    private static String DROPDOWN;
    private static String PAGETITLE;
    private static String[] InputValues;

    @BeforeAll
    static void antesDeTodosLosTest() {
        PAGETITLE = "HTML Form Elements";
        USERNAME = "Porfirio";
        PASSWORD = "12345";
        COMMENT = "this is a comment";
        CHECKBOXITEM = "cb1";
        MULTIPLESELECT = "ms1";
        DROPDOWN = "dd1";
        InputValues = new String[] { PAGETITLE, USERNAME, PASSWORD, COMMENT, CHECKBOXITEM, MULTIPLESELECT, DROPDOWN};
    }

    @BeforeEach
    void beforeEach() {
        webDriver = Utils.configureWebDriver();
        HomePage homePage = new HomePage(webDriver);
        htmlFormPage = homePage.accessHtmlFormExample();
    }

    @AfterEach
    void afterEach() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        htmlFormPage.ClosePage();
    }

    @Test
    void TestFormValid() {
        Assertions.assertEquals(htmlFormPage.GetCurrentPageTitle(), PAGETITLE, "El titulo no es el esperado.");

        htmlFormPage.InsertUserName(USERNAME);
        htmlFormPage.InsertPassword(PASSWORD);
        htmlFormPage.InsertComment(COMMENT);
        htmlFormPage.ClickCheckButton(CHECKBOXITEM);
        htmlFormPage.ClickMultiselectByOption(MULTIPLESELECT);
        htmlFormPage.SelectDropdownByOption(DROPDOWN);
        htmlFormPage.ClickSubmit();

        // Form Validation
        WebElement formResults = htmlFormPage.GetFormResults();
        boolean invalid = htmlFormPage.CheckInvalid(formResults, InputValues);
        Assertions.assertFalse(invalid, "Se encuentra una verificación pendiente.");
    }

    @Test
    void TestFormInvalidDropdown() {
        Assertions.assertEquals(htmlFormPage.GetCurrentPageTitle(), PAGETITLE, "El titulo no es el esperado.");

        htmlFormPage.InsertUserName(USERNAME);
        htmlFormPage.InsertPassword(PASSWORD);
        htmlFormPage.InsertComment(COMMENT);
        htmlFormPage.ClickCheckButton(CHECKBOXITEM);
        htmlFormPage.ClickMultiselectByOption(MULTIPLESELECT);
        htmlFormPage.ClickSubmit();

        // Form Validation
        WebElement formResults = htmlFormPage.GetFormResults();
        boolean invalid = htmlFormPage.CheckInvalid(formResults, InputValues);
        Assertions.assertTrue(invalid, "Se encuentra una verificación pendiente: " + DROPDOWN);
    }
}
