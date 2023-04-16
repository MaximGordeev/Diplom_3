package pom;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;


public class BrowserSetUp extends ExternalResource {
    WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @Override
    protected void before() throws Throwable {
        WebDriverManager.chromedriver().setup();
        //Create Chrome Options
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--test-type");
        option.addArguments("--disable-popup-bloacking");
        option.addArguments("--remote-allow-origins=*");
        option.setCapability(ChromeOptions.CAPABILITY, option);

        //System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\yandexdriver\\yandexdriver.exe");
        driver = new ChromeDriver(option);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Override
    @Step("Закрываем браузер")
    protected void after() {
        driver.quit();
    }
}

