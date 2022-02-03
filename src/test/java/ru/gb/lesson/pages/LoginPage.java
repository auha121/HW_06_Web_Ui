package ru.gb.lesson.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public MainPage login(String login, String password)
    {
        webDriver.findElement(By.xpath("//input[@name='login']")).sendKeys(login);
        webDriver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        webDriver.findElement(By.xpath("//button[@name='Login']")).click();
        return new MainPage(webDriver);
    }

    public void checkTextIncorrectIsVisible(String errorText) {
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='" + errorText + "']")));
    }
}
