package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Story("Negative Demo QA Registration form")
public class DemoqaFormNegative extends TestBase {

    @Test
    @DisplayName("Broken Registration. Error in User Number")
    void negativeUserNumberTest() {
        step("Open registration page", () ->
                demoqaPage.openPage()
                        .closeBanner());

        step("Fill registration form", () ->
                demoqaPage
                        .typeUserNumber(testData.errorUserNumber)
                        .submitForm());

        step("Checking negative form results", () ->
                demoqaPage.modalDialogNotOpen());
    }

    @Test
    @DisplayName("Broken Registration. Error in Subject field")
    void negativeSubjectTest() {
        step("Open registration page", () ->
                demoqaPage.openPage()
                        .closeBanner());

        step("Fill registration form", () ->
                demoqaPage
                        .typeSubjectInput(testData.errorSubjectsInput)
                        .submitForm());

        step("Checking negative form results", () ->
                demoqaPage.modalDialogNotOpen());
    }

    @Test
    @DisplayName("Broken Registration. Empty Form")
    void negativeEmptyFormTest() {
        step("Open registration page", () ->
                demoqaPage.openPage()
                        .closeBanner()
                        .submitForm());

        step("Checking negative form results", () ->
                demoqaPage.modalDialogNotOpen());
    }
}