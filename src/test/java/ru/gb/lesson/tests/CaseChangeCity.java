package ru.gb.lesson.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.gb.lesson.BaseTest;
import ru.gb.lesson.pages.MainPage;

@DisplayName("Изменение города")
public class CaseChangeCity extends BaseTest {

    @Test
    @DisplayName("Выбор города")
    void successfulChangeCity() throws InterruptedException {

        webDriver.get(URL);
        webDriver.manage().window().maximize();

        new MainPage(webDriver)
                .listCity()
                .changeCity()
                .changeCityButtonOk()
                .checkChangeCity();
    }
}
