package tests;

import org.junit.jupiter.api.Test;

public class DemoqaFormNegative extends TestBase {

    @Test
        //некорректное заполнение поля "Mobile"
    void negativeUserNumberTest() {
        demoqaPage.openPage()
                .closeBanner()
                .typeUserNumber(testData.errorUserNumber)
                .submitForm()
                .modalDialogNotOpen();
    }

    @Test
        //некорректное заполнение поля "Subjects"
    void negativeSubjectTest() {
        demoqaPage.openPage()
                .closeBanner()
                .typeSubjectInput(testData.errorSubjectsInput)
                .submitForm()
                .modalDialogNotOpen();
    }

    @Test
        //отправка пустой формы
    void negativeEmptyFormTest() {
        demoqaPage.openPage()
                .closeBanner()
                .submitForm()
                .modalDialogNotOpen();
    }
}