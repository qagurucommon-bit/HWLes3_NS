package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaForm extends TestBase {

    @Test
    void successfulFillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Anna");
        $("#lastName").setValue("Vetrova");
        $("#userEmail").setValue("anna.vetrova@asdfg.ru");
        $("#genterWrapper").find(byText("Female")).click();
        $("#userNumber").setValue("8923456782");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day.react-datepicker__day--010").click();
        $("#subjectsInput").setValue("Hindi").pressEnter();
        $("#hobbiesWrapper").find(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img.png");
        $("#currentAddress").setValue("Kazan");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $("#submit").click();

        // проверка результатов
        $(".table-responsive").shouldHave(text("Anna Vetrova"));
        $(".table-responsive").shouldHave(text("anna.vetrova@asdfg.ru"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("8923456782"));
        $(".table-responsive").shouldHave(text("10 May,2000"));
        $(".table-responsive").shouldHave(text("Hindi"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("img.png"));
        $(".table-responsive").shouldHave(text("Kazan"));
        $(".table-responsive").shouldHave(text("Haryana Karnal"));
        $("#closeLargeModal").click();
    }
    }