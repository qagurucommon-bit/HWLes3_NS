package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static testdata.TestData.*;

public class DemoqaFormShort extends TestBase {

    @Test
    void successfulFillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#genterWrapper").find(byText(genter)).click();
        $("#userNumber").setValue(userNumber);
        $("#submit").click();

        // проверка результатов
        $(".table-responsive").shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").shouldHave(text(genter));
        $(".table-responsive").shouldHave(text(userNumber));
        $("#closeLargeModal").click();
    }
    }