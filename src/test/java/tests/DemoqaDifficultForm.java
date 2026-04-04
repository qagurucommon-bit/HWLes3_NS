package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaDifficultForm extends TestBase {

    @Test
    void successfulFillFormTest() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("Anna");
        $("[id=lastName]").setValue("Vetrova");
        $("[id=userEmail]").setValue("anna.vetrova@asdfg.ru");
        $("[for=gender-radio-2]").click();
        $("[id=userNumber]").setValue("8923456782");
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day.react-datepicker__day--010").click();
        $("[id=subjectsInput]").setValue("Hindi");
        $(byText("Hindi")).click();
        $("#hobbies-checkbox-1[value='1']").click();
        $("#uploadPicture").uploadFromClasspath("img.png");
        $("[id=currentAddress]").setValue("Kazan");
        $("[id=state]").click();
        $(byText("Haryana")).click();
        $("[id=city]").click();
        $(byText("Karnal")).click();
        $("[id=submit]").click();

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
        $("[id=closeLargeModal]").click();
    }
    }