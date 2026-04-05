package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxShortNegative extends TestBase {

    @Test
    void negativeTestForm() {
        open("/text-box");
        $("#userEmail").setValue("qwerty");
        $("#submit").click();

        //проверка результатов
        $("#output").shouldNot(appear);
    }
}