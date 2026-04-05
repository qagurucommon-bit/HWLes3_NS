package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxShort extends TestBase {

    @Test
    void successfulFillFormTest() {
        open("/text-box");
        $("#userName").setValue("Rudolf");
        $("#submit").click();

        //проверка результатов
        $("#output #name").shouldHave(text("Rudolf"));
    }
}