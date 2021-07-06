package com.example;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class fillFormSecondTest{

    @Test
    public void LoginLogoutTest() {
        String userName = "Tom";

        open("http://uitestingplayground.com/sampleapp");
        $(By.name("UserName")).sendKeys(userName);
        $(By.name("Password")).sendKeys("pwd");
        $(By.id("login")).click();
        Assert.assertEquals($(By.id("loginstatus")).getText(), "Welcome, username!", "Login failed!");
        Assert.assertEquals($(By.id("loginstatus")).getAttribute("class"), "text-success", "Wrong login class");

        $(By.id("login")).click();
        Assert.assertEquals($(By.id("loginstatus")).getText(), "User logged out.", "Logout failed!");
        Assert.assertEquals($(By.id("loginstatus")).getAttribute("class"), "text-info", "Wrong logout class");
    }

    @Test
    public void LoginFailedTest() {
        open("http://uitestingplayground.com/sampleapp");
        $(By.name("UserName")).sendKeys("username");
        $(By.name("Password")).sendKeys("qwerty");
        $(By.id("login")).click();
        Assert.assertEquals($(By.id("loginstatus")).getText(), "Invalid username/password");
        Assert.assertEquals($(By.id("loginstatus")).getAttribute("class"), "text-danger", "Wrong log failed class");
    }

}
