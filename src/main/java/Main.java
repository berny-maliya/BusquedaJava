import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
// berny sex code.com
//busqueda de java en la biblioteca de unison
public class Main {
    public static void main(String[] args) throws InterruptedException{
        //Establecemos la propiedad webdriver.chrome.driver
        //con la ubicacion del chromedriver que descargamos
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\BernyCsti\\Downloads\\chromedriver.exe");

        //Creamos una nueva instancia de ChromeDriver
        WebDriver driver = new ChromeDriver();

        //Hacemos una llamada a esta página
        driver.get("http://bibliotecas.uson.mx");

        //buscamos la entrada de texto por el xpath
        WebElement element=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_txtBuscar\"]"));

        //ingresamos el texto a buscar
        element.sendKeys("Java");
        Thread.sleep(1000);

        WebElement boton=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_btnBuscar_input\"]"));
        boton.click();

        WebElement ficha= driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridResultados_ctl00_ctl04_LinkButton1\"]"));
        ficha.click();

        // Agregar este sleep para poder visualizar la ficha durante un instante antes de ejecutar el quit() del driver
        //Thread.sleep(2000);

        // Validar la ventana de la ficha bibliográfica
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement alert = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"RadWindowWrapper_ctl00_ContentPlaceHolder1_x\"]/table/tbody/tr[1]/td[2]/table/tbody/tr/td[2]/em"))));

        String alertText = alert.getText();

        assertEquals("FICHA BIBLIOGRAFICA", alertText);

        // Cerramos el navegador
        driver.quit();

    }
}