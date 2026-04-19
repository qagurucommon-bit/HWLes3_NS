package tests;

import org.junit.jupiter.api.Test;

import static tests.testdata.TestData.*;

public class DemoqaFormShort extends TestBase {

    @Test
    void successfulFillFormTest() {
        demoqaPage.openPage()
                .closeBanner()
                .typeFirstName(testData.firstName)
                .typeLastName(testData.lastName)
                .setGender(testData.genter)
                .typeUserNumber(testData.userNumber)
                .submitForm()
                .modalDialogOpen()
                .checkTitle(tableTitle)
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Gender", testData.genter)
                .checkResult("Mobile", testData.userNumber)
                .closeModal();

    }
}