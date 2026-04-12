package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.*;
import static testdata.TestData.*;

public class DemoqaFormNegative extends TestBase {

    @Test
        //некорректное заполнение поля "Mobile"
    void negativeUserNumberTest() {
        open("/automation-practice-form");
        executeJavaScript("""
                    document.getElementById('fixedban')?.remove();
                    document.querySelector('footer')?.remove();
                """);
        $("#userNumber").setValue(errorUserNumber);
        $("#submit").click();

        // проверка результатов
        $(".modal-dialog modal-lg").shouldNot(appear);
    }

    @Test
        //некорректное заполнение поля "Subjects"
    void negativeSubjectTest() {
        open("/automation-practice-form");
        executeJavaScript("""
                    document.getElementById('fixedban')?.remove();
                    document.querySelector('footer')?.remove();
                """);
        $("#subjectsInput").setValue(errorSubjectsInput).pressEnter();
        $("#submit").click();

        // проверка результатов
        $(".modal-dialog modal-lg").shouldNot(appear);
    }

    @Test
        //отправка пустой формы
    void negativeEmptyFormTest() {
        open("/automation-practice-form");
        executeJavaScript("""
                    document.getElementById('fixedban')?.remove();
                    document.querySelector('footer')?.remove();
                """);
        $("#submit").click();

        // проверка результатов
        $(".modal-dialog modal-lg").shouldNot(appear);
    }
}