import pom.HomePage;
import pom.HtmlFormPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;

import java.util.List;

public class Test1 {
    private WebDriver webDriver;
    private HtmlFormPage htmlFormPage;
    private static  String USERNAME;
    private static String TITULOPAGINA;
    private static String PASSWORD;
    private static String EMAIL;
    private static String TELEFONO;
    private static String DIRECCION;
    private static String CIUDAD;
    private static String ESTADO;
    private static String ZIP;
    private static String SITIOWEB;
    private static String HOSTING;
    private static String COMENTARIO;

    @BeforeAll
    static void antesDeTodosLosTest() {
        TITULOPAGINA = "Selenium Easy - Input Form Demo with Validations";
        USERNAME = "Leonardo";
        PASSWORD = "Perez";
        EMAIL = "lperez@ces.com.uy";
        TELEFONO = "(845)555-1212";
        DIRECCION = "Direccion";
        CIUDAD = "Ciudad";
        ESTADO = "Virginia";
        ZIP = "98370";
        SITIOWEB = "ces.com.uy";
        HOSTING = "Yes";
        COMENTARIO = "Esto es un comentario.";
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
        htmlFormPage.cerrarSitio();
    }

    @Test
    void camposCompletos() {
        Assertions.assertEquals(htmlFormPage.obtenerTitulo(), TITULOPAGINA, "El titulo no es el esperado.");

        htmlFormPage.insertUserName(USERNAME);
        htmlFormPage.insertPassword(PASSWORD);
        htmlFormPage.ingresarEmail(EMAIL);
        htmlFormPage.ingresarTelefono(TELEFONO);
        htmlFormPage.ingresarDireccion(DIRECCION);
        htmlFormPage.ingresarCiudad(CIUDAD);
        htmlFormPage.seleccionarEstado(ESTADO);
        htmlFormPage.ingresarZip(ZIP);
        htmlFormPage.ingresarSitioWeb(SITIOWEB);
        htmlFormPage.tieneHosting(HOSTING);
        htmlFormPage.ingresarComentario(COMENTARIO);
        htmlFormPage.clickSend();

        //validacion formulario
        List<WebElement> listaEtiquetasSmall = htmlFormPage.obtenerAlertas();
        boolean invalid = htmlFormPage.contieneINVALID(listaEtiquetasSmall);
        Assertions.assertFalse(invalid, "Se encuentra una verificacion pendiente.");
    }
}
