package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static testdata.TestData.*;

public class DemoqaForm extends TestBase {

    @Test
    void successfulFillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").find(byText(genter)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0"+day).click();
        $("#subjectsInput").setValue(subjectsInput).pressEnter();
        $("#hobbiesWrapper").find(byText(hobbies)).click();
        $("#uploadPicture").uploadFromClasspath(pictureName);
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        $("#submit").click();

        // проверка результатов
        $(".table-responsive").shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").shouldHave(text(userEmail));
        $(".table-responsive").shouldHave(text(genter));
        $(".table-responsive").shouldHave(text(userNumber));
        $(".modal-body").shouldHave(text(day + " " + month + "," + year));
        $(".table-responsive").shouldHave(text(subjectsInput));
        $(".table-responsive").shouldHave(text(hobbies));
        $(".table-responsive").shouldHave(text(pictureName));
        $(".table-responsive").shouldHave(text(currentAddress));
        $(".table-responsive").shouldHave(text(state + " " + city));
        $("#closeLargeModal").click();
    }
    }