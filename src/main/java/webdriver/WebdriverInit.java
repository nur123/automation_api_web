package webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebdriverInit {

    public static WebDriver driver;


    public static void initialize() {

        WebDriverManager.chromedriver().setup();
        // buka browser - inisialisasi si Webdriver
        driver = new ChromeDriver();
        //setting timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //maximize
        driver.manage().window().maximize();

    }

    public static void quit() {
        driver.quit();
    }

}
