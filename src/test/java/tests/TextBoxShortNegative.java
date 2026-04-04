package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxShortNegative extends TestBase {

    @Test
    void NegativeTestForm() {
        open("/text-box");
        $("[id=userEmail]").setValue("qwerty");
        $("[id=submit]").click();

        //проверка результатов
        $("[id=output]").shouldNot(appear);

    }
}