package driver;

import java.nio.file.Paths;

public class DriverContext {

    private static DriverManager driverManager  = new DriverManager();

//    public static void setUp(String nombreDispositivo, String sistemaOperativo, String rutaApp, String udID, Boolean emulador){
//        driverManager.setUp(nombreDispositivo,sistemaOperativo,rutaApp,udID, emulador);
//    }
    public static void setUp(String[] args) throws InterruptedException {

        String path = Paths.get(System.getProperty("user.dir"), "/src/main/resources/drivers/chromedriver").toString();
        //String path = "/Users/ignaciofuentes/Desktop/SeleniumPrimerosPasos/src/main/resources/drivers/chromedriver";
        System.setProperty("webdriver.chrome.driver", path);

    }





    public static void quitDriver(){

        driver.close();

    }
}

