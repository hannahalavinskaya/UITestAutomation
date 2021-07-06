package org.selenide.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class textInputTest {

    @Test
    public void SetNewButtonName() {
        String newValue = "Any new Button";

        open("http://uitestingplayground.com/textinput?");
        $(By.id("newButtonName")).setValue(newValue); // вводим новое значение (берем из переменной newValue)
        WebElement button = $(By.id("updatingButton")); // присваиваем значение переменной WebElement button
        button.click();
        Assert.assertEquals(button.getText(), newValue); //считать текст с кнопки, которую нашли и сравнить с тем, что передали
    }
}