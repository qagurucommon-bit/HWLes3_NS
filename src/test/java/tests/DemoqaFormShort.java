package tests;

import org.junit.jupiter.api.Test;

import static tests.testdata.TestData.*;

public class DemoqaFormShort extends TestBase {

    @Test
    void successfulFillFormTest() {
        demoqaPage.openPage()
                .closeBanner()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .setGender(genter)
                .typeUserNumber(userNumber)
                .submitForm()

                // проверка результатов
                .modalDialogOpen()
                .checkTitle(tableTitle)
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", genter)
                .checkResult("Mobile", userNumber)
                .closeModal();

    }
}