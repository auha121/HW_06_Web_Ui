package ru.gb.lesson.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CardProductPage extends BasePage {

    public CardProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CardProductPage putProductInCart() {
        webDriver.findElement(By.xpath("//a[contains(text(),'Добавить в корзину')]")).click();
        return this;
    }

    public CartPage goToCart() {
        webDriver.findElement(By.xpath("//a[contains(text(),'Перейти в корзину')]")).click();
        return new CartPage(webDriver);
    }
}
