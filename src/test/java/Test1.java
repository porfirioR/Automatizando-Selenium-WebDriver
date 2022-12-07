import pom.HomePage;
import pom.InputFormDemoPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;

import java.util.List;

public class Test1 {
    private WebDriver webDriver;
    private InputFormDemoPage inputFormDemoPage;
    private static  String NOMBRE;
    private static String TITULOPAGINA;
    private static String APELLIDO;
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
        NOMBRE = "Leonardo";
        APELLIDO = "Perez";
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
        inputFormDemoPage = homePage.accessInputFormDemo();
    }

    @AfterEach
    void afterEach() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        inputFormDemoPage.cerrarSitio();
    }

    @Test
    void camposCompletos() {
        Assertions.assertEquals(inputFormDemoPage.obtenerTitulo(), TITULOPAGINA, "El titulo no es el esperado.");

        inputFormDemoPage.ingresarNombre(NOMBRE);
        inputFormDemoPage.ingresarApellido(APELLIDO);
        inputFormDemoPage.ingresarEmail(EMAIL);
        inputFormDemoPage.ingresarTelefono(TELEFONO);
        inputFormDemoPage.ingresarDireccion(DIRECCION);
        inputFormDemoPage.ingresarCiudad(CIUDAD);
        inputFormDemoPage.seleccionarEstado(ESTADO);
        inputFormDemoPage.ingresarZip(ZIP);
        inputFormDemoPage.ingresarSitioWeb(SITIOWEB);
        inputFormDemoPage.tieneHosting(HOSTING);
        inputFormDemoPage.ingresarComentario(COMENTARIO);
        inputFormDemoPage.clickSend();

        //validacion formulario
        List<WebElement> listaEtiquetasSmall = inputFormDemoPage.obtenerAlertas();
        boolean invalid = inputFormDemoPage.contieneINVALID(listaEtiquetasSmall);
        Assertions.assertFalse(invalid, "Se encuentra una verificacion pendiente.");
    }
}
