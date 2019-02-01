package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    private static WebDriver driver;


    /**
     * Initialize ChromeDriver
     * Path to chromedriver.exe need to be set in System.setProperty
     */
    private static void  initDriver (){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\globoget\\IdeaProjects\\vladislavAangelovTest\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /**
     * @return driver
     */
    public static WebDriver getDriver (){
        if(driver == null){
            initDriver();
        }
        return driver;
    }


    /**
     * Quit the browser and set driver to null
     */
    public static void tearDown (){
        driver.quit();
        driver = null;
    }

}
