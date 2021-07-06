package org.selenide.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class fillFormTest {
    WebDriver driver; //объявили переменную

    @BeforeClass
    public void initDriver(){
        String path = System.getProperty("user.dir"); // путь к папке, где лежит проект
        System.setProperty("webdriver.chrome.driver",path + "\\chromedriver.exe"); // the setProperty method enables QAs to set the properties for the desired browser to be used in test automation.
        driver = new ChromeDriver(); //Initilize new driver
        driver.get("http://uitestingplayground.com/sampleapp"); // open browser
        driver.manage().window().maximize(); //расширить окно браузера
    }

    @Test
    public void validUsernamePassword() {
        String userName = "Tom";

        driver.findElement(By.name("UserName")).sendKeys(userName); // вводим новое значение (берем из переменной newValue)
        driver.findElement(By.name("Password")).sendKeys("pwd"); // вводим определенный пароль
        driver.findElement(By.id("login")).click(); //найти кнопку login, нажать
        Assert.assertEquals(driver.findElement(By.id("loginstatus")).getText(), "Welcome, "+userName+"!", "Login failed");
        Assert.assertEquals(driver.findElement(By.id("loginstatus")).getAttribute("class"), "text-success", "Wrong login class");
    }

    @Test
    public void invalidPassword() {
        String userName = "Greg";

        driver.findElement(By.name("UserName")).sendKeys(userName); // вводим новое значение (берем из переменной newValue)
        driver.findElement(By.name("Password")).sendKeys("qwerty"); // вводим определенный пароль
        driver.findElement(By.id("login")).click(); //найти кнопку login, нажать
        Assert.assertEquals(driver.findElement(By.id("loginstatus")).getText(), "Invalid username/password");
        Assert.assertEquals(driver.findElement(By.id("loginstatus")).getAttribute("class"), "text-danger", "Wrong log failed class");
    }

    @Test
    public void logInlogOut() {
        String userName = "Monika";

        driver.findElement(By.name("UserName")).sendKeys(userName); // вводим новое значение (берем из переменной newValue)
        driver.findElement(By.name("Password")).sendKeys("pwd"); // вводим определенный пароль
        driver.findElement(By.id("login")).click(); //найти кнопку login, нажать
        driver.findElement(By.id("login")).click(); //нажать повторно
        Assert.assertEquals(driver.findElement(By.id("loginstatus")).getText(), "User logged out.");
        Assert.assertEquals(driver.findElement(By.id("loginstatus")).getAttribute("class"), "text-info", "Wrong logout class");
    }

    @AfterClass
    public void quitDriver() {
        driver.close();
        driver.quit();
    }
}



