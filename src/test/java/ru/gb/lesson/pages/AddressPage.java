package ru.gb.lesson.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AddressPage extends BasePage{

    public AddressPage(WebDriver webDriver) {
        super(webDriver);
    }

    public AddressPage inputCity() {
        webDriver.findElement(By.xpath("//form[@id='search-location']//input[@name='q']")).sendKeys("Верхняя Пышма");
        return this;
    }

    public AddressPage searchAddressInCity() {
        webDriver.findElement(By.xpath("//form[@id='search-location']//button[@class='search-form__submit']")).click();
        return this;
    }

    public AddressPage checkAddressInCity() {
        assertThat(webDriver.findElement(By.xpath("//div[@class='shops-table-item__address']")).getText())
                .as("Адрес магазина должен быть " + "г.Верхняя Пышма, ул.Уральских рабочих, д.42А")
                .isEqualTo("г.Верхняя Пышма, ул.Уральских рабочих, д.42А");
        return this;
    }
}
