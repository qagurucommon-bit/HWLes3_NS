package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.*;
import static testdata.TestData.*;

public class TextBoxShortNegative extends TestBase {

    @Test
    void negativeFormTest() {
        open("/text-box");
        executeJavaScript("""
                    document.getElementById('fixedban')?.remove();
                    document.querySelector('footer')?.remove();
                """);
        $("#userEmail").setValue(errorUserEmail);
        $("#submit").click();

        //проверка результатов
        $("#output").shouldNot(appear);
    }
}