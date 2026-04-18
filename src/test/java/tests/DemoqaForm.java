package tests;

import org.junit.jupiter.api.Test;

import static tests.testdata.TestData.*;

public class DemoqaForm extends TestBase {

    @Test
    void successfulFillFormTest() {
        demoqaPage.openPage()
                .closeBanner()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(userEmail)
                .setGender(genter)
                .typeUserNumber(userNumber)
                .setDateOfBirth(day, month, year)
                .typeSubjectInput(subjectsInput)
                .setHobbies(hobbies)
                .uploadPicture(pictureName)
                .typeCurrentAddress(currentAddress)
                .setStateAndCity(state, city)
                .submitForm()

                //проверка результатов
                .modalDialogOpen()
                .checkTitle(tableTitle)
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", genter)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", subjectsInput)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", pictureName)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city)
                .closeModal();
    }
}