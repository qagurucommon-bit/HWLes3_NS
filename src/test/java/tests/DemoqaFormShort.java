package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static tests.testdata.TestData.tableTitle;

@Story("Short Demo QA Registration form")
public class DemoqaFormShort extends TestBase {

    @Test
    @DisplayName("Successful Registration")
    void successfulFillFormTest() {
        step("Open registration page", () ->
                demoqaPage.openPage()
                        .closeBanner());

        step("Fill registration form", () ->
                demoqaPage
                        .typeFirstName(testData.firstName)
                        .typeLastName(testData.lastName)
                        .setGender(testData.genter)
                        .typeUserNumber(testData.userNumber)
                        .submitForm());

        step("Checking form results", () ->
                demoqaPage
                        .modalDialogOpen()
                        .checkTitle(tableTitle)
                        .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                        .checkResult("Gender", testData.genter)
                        .checkResult("Mobile", testData.userNumber)
                        .closeModal());

    }
}