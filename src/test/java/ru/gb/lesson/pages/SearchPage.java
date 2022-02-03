package ru.gb.lesson.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage{

    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CardProductPage selectProductInCartInSearchPage() {
        webDriver.findElement(By.xpath("//span[@href='#' and @data-id='573485']")).click();
        return new CardProductPage(webDriver);
    }
}
