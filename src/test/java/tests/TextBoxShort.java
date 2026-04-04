package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxShort extends TestBase {

    @Test
    void successfulFillFormTest() {
        open("/text-box");
        $("[id=userName]").setValue("Rudolf");
        $("[id=submit]").click();

        //проверка результатов
        $("[id=output] [id=name]").shouldHave(text("Rudolf"));

    }
}