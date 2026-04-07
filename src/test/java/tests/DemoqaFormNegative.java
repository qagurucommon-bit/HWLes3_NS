package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static testdata.TestData.*;

public class DemoqaFormNegative extends TestBase {

    @Test //некорректное заполнение поля "Mobile"
    void negativeTestUserNumber () {
        open("/automation-practice-form");
        $("#userNumber").setValue(errorUserNumber);
        $("#submit").click();

        // проверка результатов
        $(".modal-dialog modal-lg").shouldNot(appear);
    }

    @Test //некорректное заполнение поля "Subjects"
    void negativeTestSubject () {
        open("/automation-practice-form");
        $("#subjectsInput").setValue(errorSubjectsInput).pressEnter();
        $("#submit").click();

        // проверка результатов
        $(".modal-dialog modal-lg").shouldNot(appear);
    }

    @Test //отправка пустой формы
    void negativeTestsEmptyForm () {
        open("/automation-practice-form");
        $("#submit").click();

        // проверка результатов
        $(".modal-dialog modal-lg").shouldNot(appear);
    }
}