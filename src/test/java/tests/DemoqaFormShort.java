package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DemoqaFormShort extends TestBase {

    @Test
    void successfulFillFormTest() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("Anna");
        $("[id=lastName]").setValue("Vetrova");
        $("[for=gender-radio-2]").click();
        $("[id=userNumber]").setValue("8923456782");
        $("[id=submit]").click();

        // проверка результатов
        $(".table-responsive").shouldHave(text("Anna Vetrova"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("8923456782"));
        $("[id=closeLargeModal]").click();
    }
    }