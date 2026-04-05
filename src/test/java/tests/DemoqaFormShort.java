package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DemoqaFormShort extends TestBase {

    @Test
    void successfulFillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Anna");
        $("#lastName").setValue("Vetrova");
        $("#genterWrapper").find(byText("Female")).click();
        $("#userNumber").setValue("8923456782");
        $("#submit").click();

        // проверка результатов
        $(".table-responsive").shouldHave(text("Anna Vetrova"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("8923456782"));
        $("#closeLargeModal").click();
    }
    }