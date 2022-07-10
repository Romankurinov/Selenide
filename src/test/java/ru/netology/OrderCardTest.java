package ru.netology;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class OrderCardTest {

    public String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @Test
    public void CompletedForm() {
            open("http://localhost:9999");
            $("[data-test-id=city] input").setValue("Краснодар");
            $("[data-test-id=name] input").setValue("Куринов Роман");
            String planningDate = generateDate(7);
            $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
            $("[data-test-id='date'] input").setValue(planningDate);
            $("[data-test-id=phone] input").setValue("+79991231111");
            $("[data-test-id=agreement]").click();
            $(".button").click();
            $("[data-test-id='notification']").should(visible, Duration.ofSeconds(15));
    }



}
