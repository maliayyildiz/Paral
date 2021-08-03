package parallel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;


public class Driver {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private Driver(){}

    public static WebDriver getDriver(){
        // Eğer driver nesnesi hafızada boşsa, oluşturulmamışsa yeniden oluşturmana gerek yok.
        // Eğer null ise, yeniden oluşturabilirsin.
        // Sadece ilk çağırıldığında bir tane nesne üret, sonraki çağırmalarda var olan nesnesi kullan.
        if(driver.get() == null){
            switch (ConfigurationReader.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver.set( new ChromeDriver());
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver());
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver.set(new InternetExplorerDriver());
                    break;
                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver.set( new SafariDriver());
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));
                    break;
            }
        }
        return driver.get();
    }

    public static void closeDriver(){
            driver.get().quit();  // driver'ı kapat
            driver.remove(); // driver'ı hafızadan temizle.
    }
}