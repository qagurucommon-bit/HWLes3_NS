package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static testdata.TestData.*;

public class TextBoxShort extends TestBase {

    @Test
    void successfulFillFormTest() {
        open("/text-box");
        executeJavaScript("""
                    document.getElementById('fixedban')?.remove();
                    document.querySelector('footer')?.remove();
                """);
        $("#userName").setValue(userName);
        $("#submit").click();

        //проверка результатов
        $("#output #name").shouldHave(text(userName));
    }
}