package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static tests.testdata.TestData.tableTitle;

@Story("Registration Demo QA     form")
public class DemoqaForm extends TestBase {

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
                        .typeEmail(testData.userEmail)
                        .setGender(testData.genter)
                        .typeUserNumber(testData.userNumber)
                        .setDateOfBirth(testData.day, testData.month, testData.year)
                        .typeSubjectInput(testData.subjectsInput)
                        .setHobbies(testData.hobbies)
                        .uploadPicture(testData.pictureName)
                        .typeCurrentAddress(testData.currentAddress)
                        .setStateAndCity(testData.state, testData.city)
                        .submitForm());

        step("Checking form results", () ->
                demoqaPage
                        .modalDialogOpen()
                        .checkTitle(tableTitle)
                        .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                        .checkResult("Student Email", testData.userEmail)
                        .checkResult("Gender", testData.genter)
                        .checkResult("Mobile", testData.userNumber)
                        .checkResult("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
                        .checkResult("Subjects", testData.subjectsInput)
                        .checkResult("Hobbies", testData.hobbies)
                        .checkResult("Picture", testData.pictureName)
                        .checkResult("Address", testData.currentAddress)
                        .checkResult("State and City", testData.state + " " + testData.city)
                        .closeModal());
    }
}