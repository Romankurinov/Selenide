package ru.netology;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class OrderCardTest {
    @Test
    public void CompletedForm() {
            open("http://localhost:9999");
            $("[data-test-id=city] input").setValue("Краснодар");
            $("[data-test-id=name] input").setValue("Куринов Роман");
            $("[data-test-id=phone] input").setValue("+79991231111");
            $("[data-test-id=agreement]").click();
            $(".button").click();
            $("[data-test-id=notification]").should(visible, Duration.ofSeconds(15));
            $("[class=notification__content]").should(text("Встреча успешно забронирована на "+$("[data-test-id=date] input").getValue()), Duration.ofSeconds(20));
    }
}
