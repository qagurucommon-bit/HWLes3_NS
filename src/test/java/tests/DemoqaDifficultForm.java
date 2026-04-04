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

      //  $("[id=output] [id=name]").shouldHave(text("Alex Black"));
        //$("[id=output] [id=email]").shouldHave(text("alex@black.com"));
       // $("[id=output] [id=currentAddress]").shouldHave(text("first address 1"));
        // $("[id=output] [id=permanentAddress]").shouldHave(text("second address 2"));
    }
}