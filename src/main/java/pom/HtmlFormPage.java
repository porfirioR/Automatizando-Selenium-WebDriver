package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PropertyReader;

import java.util.List;

public class HtmlFormPage extends BasePage {
    private By userNameBy;
    private By passwordBy;
    private By textAreaCommentBy;
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

    public HtmlFormPage(WebDriver webDriver) {
        super(webDriver);

        try {
            if (!getTitle().equals(PropertyReader.getEnvironment("html_form_title")))
                throw new Exception("La pagina no es la esperada.");

            userNameBy = By.name("first_name");
            passwordBy = By.name("last_name");
            textAreaCommentBy = By.name("email");
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
    public void insertUserName(String userName) {
        senKeys(userNameBy, userName);
    }

    public void insertPassword(String password) {
        senKeys(passwordBy, password);
    }

    public void ingresarEmail(String email) {
        senKeys(textAreaCommentBy, email);
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
