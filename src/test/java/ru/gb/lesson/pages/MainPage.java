package ru.gb.lesson.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class MainPage extends BasePage {

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage clickLoginButton() {
        webDriver.findElement(By.xpath("//a[@title='Личный кабинет']")).click();
        return new LoginPage(webDriver);
    }

    public MainPage clickBannerButton() {
        webDriver.findElement(By.xpath("//div[@id='poolLink']/child::button")).click();
        return new MainPage(webDriver);
    }

    public MainPage checkLogoutButtonIsVisible() {
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Выйти']")));
        return this;
    }

    public ProductsPage goToProductPage() {
        webDriver.findElement(By.xpath("//div[@href='#catalog-dropdown']")).click();
        webDriver.findElement(By.xpath("//a[@href='/catalog/dlya-doma/']")).click();
        return new ProductsPage(webDriver);
    }

    public MainPage listCity() {
        webDriver.findElement(By.xpath("//span[@class='header-city__select js-city-dropdown-toggle']")).click();
        return this;
    }

    public MainPage changeCity() {
        webDriver.findElement(By.xpath("//li[text()='г.Остров']")).click();
        return this;
    }

    public MainPage changeCityButtonOk() {
        webDriver.findElement(By.xpath("//button[@id='button-change-city']")).click();
        return this;
    }

    public MainPage checkChangeCity() throws InterruptedException {
        Thread.sleep(500);
        assertThat(webDriver.findElement(By.xpath("//span[@class='header-city__select js-city-dropdown-toggle']")).getText())
                .as("Город должен быть " + "г.Остров")
                .isEqualTo("г.Остров");
        return this;
    }

    public AddressPage goToAddressPage() {
        webDriver.findElement(By.xpath("//a[contains(text(),'Адреса магазинов')]")).click();
        return new AddressPage(webDriver);
    }

    public MainPage inputQuery() {
        webDriver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("нож");
        return this;
    }

    public SearchPage searchQuery() {
        webDriver.findElement(By.xpath("//form[@id='search']//button[@class='header-search__btn']")).click();
        return new SearchPage(webDriver);
    }
}
