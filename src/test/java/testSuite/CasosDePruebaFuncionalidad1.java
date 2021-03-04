package testSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class CasosDePruebaFuncionalidad1 {
    //Atributos
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void preparacion_tests(){
        String path = Paths.get(System.getProperty("user.dir"),"\\src\\main\\resources\\drivers\\chromedriver").toString();
        System.setProperty("webdriver.chrome.driver", path);

        driver = new ChromeDriver();

        wait = new WebDriverWait(driver,10);

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void inicio_tests(){
        driver.get("https://www.falabella.com/falabella-cl/");

        driver.manage().window().maximize();
    }


    @Test
    public void CP001_Agregar_Producto_Bolsa(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div/div[1]")));
        if(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]")).isDisplayed()){
            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]")).click();
        }

        //declaración de un objeto de tipo localizador (By)
        By txtBuscar = By.xpath("/html[1]/body[1]/div[1]/nav[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");

        //declaración de un elemento web
        WebElement webElementBuscar = driver.findElement(txtBuscar);

        //llamada a la función sendkeys del elemento web la cual envia una combinación de caracteres
        webElementBuscar.sendKeys("audifonos");

        wait.until(
                ExpectedConditions.presenceOfElementLocated
                        (By.xpath("/html[1]/body[1]/div[8]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[8]"))).click();

        WebElement btnCerrarPopUp = wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("#acc-alert-close"))));
        if(btnCerrarPopUp.isDisplayed()){
            btnCerrarPopUp.click();
        }

        By filtroBose = By.xpath("//span[contains(text(),'bose')]");


        wait.until(ExpectedConditions.elementToBeClickable(filtroBose)).click();


        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@id='testId-pod-image-8689073']"))).click();

        WebElement agregarBolsa = wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//button[contains(text(),'Agregar a la Bolsa')]"))));

        agregarBolsa.click();

        String resultadoEsperado = "Producto(s) agregado(s) a la bolsa de compras";


        String resultadoActual = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Producto(s) agregado(s)')]"))).getText();

        System.out.println(resultadoEsperado);

        if(resultadoActual.equals(resultadoEsperado)){
            System.out.println("Caso de prueba ok");
        }else{
            System.out.println("error en verificación de producto agregado a bolsa");
        }
    }

    @Test
    public void CP002_Algo(){

        Assert.assertTrue(true);
    }

    @Test
    public void CP003_Otra_Cosa(){
        Assert.assertTrue(false);
    }

    @AfterMethod
    public void limpiar_tests(){
        driver.close();
    }

    @AfterTest
    public void post_ejecucion_tests(){
        System.out.println("Se finaliza la ejecución.");
    }



}
