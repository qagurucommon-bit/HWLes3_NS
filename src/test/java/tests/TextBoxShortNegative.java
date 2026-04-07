package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static testdata.TestData.*;

public class TextBoxShortNegative extends TestBase {

    @Test
    void negativeTestForm() {
        open("/text-box");
        $("#userEmail").setValue(errorUserEmail);
        $("#submit").click();

        //проверка результатов
        $("#output").shouldNot(appear);
    }
}