package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PropertyReader;

import java.util.List;

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
    private By hostingBy;
    private By commentBy;
    private By btnSend;
    private By alertSmall;

    public InputFormDemoPage(WebDriver webDriver) {
        super(webDriver);

        try {
            if (!getTitle().equals(PropertyReader.getEnvironment("input_form_demo_title")))
                throw new Exception("La pagina no es la esperada.");

            firstNameBy = By.name("first_name");
            lastNameBy = By.name("last_name");
            emailBy = By.name("email");
            phoneBy = By.name("phone");
            addressBy = By.name("address");
            cityBy = By.name("city");
            stateBy = By.name("state");
            zipBy = By.name("zip");
            webSiteBy = By.name("website");
            hostingBy = By.name("hosting");
            commentBy = By.name("comment");
            btnSend = By.cssSelector(".btn");
            alertSmall = By.tagName("small");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //endregion

    //region [Metodos]
    public void ingresarNombre(String nombre) {
        senKeys(firstNameBy, nombre);
    }

    public void ingresarApellido(String apellido) {
        senKeys(lastNameBy, apellido);
    }

    public void ingresarEmail(String email) {
        senKeys(emailBy, email);
    }

    public void ingresarTelefono(String telefono) {
        senKeys(phoneBy, telefono);
    }

    public void ingresarDireccion(String direccion) {
        senKeys(addressBy, direccion);
    }

    public void ingresarCiudad(String ciudad) {

        senKeys(cityBy, ciudad);
    }

    public void seleccionarEstado(String estado) {

        selectByVisibleText(stateBy, estado);
    }

    public void ingresarZip(String zip) {
        senKeys(zipBy, zip);
    }

    public void ingresarSitioWeb(String sitioWeb) {
        senKeys(webSiteBy, sitioWeb);
    }

    public void tieneHosting(String opcion) {
        for (WebElement element : webDriver.findElements(hostingBy))
            if (element.getText().contains(opcion))
                element.click();
    }

    public void ingresarComentario(String comentario) {
        senKeys(commentBy, comentario);
    }

    public void clickSend() {
        click(btnSend);
    }

    public List<WebElement> obtenerAlertas() {
        return webDriver.findElements(alertSmall);
    }

    public boolean contieneINVALID(List<WebElement> listaEtiquetasSmall) {
        boolean invalid = false;
        String atributo = "data-bv-result";
        String atributoValor = "INVALID";

        for (WebElement item : listaEtiquetasSmall)
            if (item.getAttribute(atributo).equals(atributoValor))
                invalid = true;

        return invalid;
    }

    public String obtenerTitulo(){
        return getTitle();
    }

    public void cerrarSitio(){
        quit();
    }

}
