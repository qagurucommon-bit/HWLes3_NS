package tests;

import org.junit.jupiter.api.Test;

import static tests.testdata.TestData.errorSubjectsInput;
import static tests.testdata.TestData.errorUserNumber;

public class DemoqaFormNegative extends TestBase {

    @Test
        //некорректное заполнение поля "Mobile"
    void negativeUserNumberTest() {
        demoqaPage.openPage()
                .closeBanner()
                .typeUserNumber(errorUserNumber)
                .submitForm()

                // проверка результатов
                .modalDialogNotOpen();
    }

    @Test
        //некорректное заполнение поля "Subjects"
    void negativeSubjectTest() {
        demoqaPage.openPage()
                .closeBanner()
                .typeSubjectInput(errorSubjectsInput)
                .submitForm()

                // проверка результатов
                .modalDialogNotOpen();
    }

    @Test
        //отправка пустой формы
    void negativeEmptyFormTest() {
        demoqaPage.openPage()
                .closeBanner()
                .submitForm()

                // проверка результатов
                .modalDialogNotOpen();
    }
}