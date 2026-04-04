package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DemoqaFormNegative extends TestBase {

    @Test //некорректное заполнение поля "Mobile"
    void NegativeTestUserNumber () {
        open("/automation-practice-form");

        $("[id=userNumber]").setValue("qwerty");
        $("[id=submit]").click();

        // проверка результатов
        $(".modal-dialog modal-lg").shouldNot(appear);

    }

    @Test //некорректное заполнение поля "Subjects"
    void NegativeTestSubject () {
        open("/automation-practice-form");

        $("[id=subjectsInput]").setValue("12345");
        $("[id=submit]").click();

        // проверка результатов
        $(".modal-dialog modal-lg").shouldNot(appear);

    }

    @Test //отправка пустой формы
    void NegativeTestsEmptyForm () {
        open("/automation-practice-form");

        $("[id=submit]").click();

        // проверка результатов
        $(".modal-dialog modal-lg").shouldNot(appear);

    }
}