package ru.gb.lesson.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.gb.lesson.BaseTest;
import ru.gb.lesson.pages.MainPage;

@DisplayName("Адреса магазинов")
public class CaseChangeAddress extends BaseTest {

    @Test
    @DisplayName("Адреса магазинов")
    void successfulAddressTest() {

        webDriver.get(URL);
        webDriver.manage().window().maximize();

        new MainPage(webDriver)
                .goToAddressPage()
                .inputCity()
                .searchAddressInCity()
                .checkAddressInCity();
    }
}
