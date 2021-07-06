package org.selenide.examples;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.files.DownloadActions.click;
import static com.codeborne.selenide.Selenide.*;


public class clickButtonTest {
    WebDriver driver; //объявили переменную

    @BeforeClass
    public void initDriver(){
        String path = System.getProperty("user.dir"); // путь к папке, где лежит проект
        System.setProperty("webdriver.chrome.driver",path + "\\chromedriver.exe"); // the setProperty method enables QAs to set the properties for the desired browser to be used in test automation.
        driver = new ChromeDriver(); //Initilize new driver
        driver.get("http://uitestingplayground.com/classattr"); // open browser
        driver.manage().window().maximize(); //расширить окно браузера
    }

    @Test
    public void userCanClickPrimaryButton() {
        //open("http://uitestingplayground.com/classattr");
        //$(By.xpath("//button[contains(concat(' ', normalize-space(@class), ' '), ' btn-primary ')]")).click();

        WebElement primaryButton = driver.findElement(By.xpath("//button[contains(concat(' ', normalize-space(@class), ' '), ' btn-primary ')]"));
        primaryButton.click();
        driver.switchTo().alert().accept(); // This method is used to click on the ‘OK’ button of the alert.
    }

    @Test
    public void userCanClickSuccessButton() {
        WebElement successButton = driver.findElement(By.xpath("//button[contains(concat(' ', normalize-space(@class), ' '), ' btn-success ')]"));
        successButton.click();
    }

    @Test
    public void userCanClickWarningButton() {
        WebElement warningButton = driver.findElement(By.xpath("//button[contains(concat(' ', normalize-space(@class), ' '), ' btn-warning ')]"));
        warningButton.click();
    }

    @AfterClass
    public void quitDriver() {
        driver.close();
        driver.quit();
    }
}
