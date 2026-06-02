package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class TextBoxShortNegative extends TestBase {

    @Test
    @DisplayName("Broken Registration")
    void negativeFormTest() {
        step("Open registration page", () ->
                testBoxPage.openPage()
                        .closeBanner());

        step("Fill registration form", () ->
                testBoxPage
                        .typeUserEmail(testData.errorUserEmail)
                        .submitForm());

        step("Checking form results", () ->
                testBoxPage.checkResultNotOpened());
    }
}