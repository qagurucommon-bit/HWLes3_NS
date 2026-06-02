package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class TextBoxShort extends TestBase {

    @Test
    @DisplayName("Successful Registration")
    void successfulFillFormTest() {
        step("Open registration page", () ->
                testBoxPage
                        .openPage()
                        .closeBanner());

        step("Fill registration form", () ->
                testBoxPage
                        .typeUserName(testData.userName)
                        .submitForm());

        step("Checking form results", () ->
                testBoxPage.checkResult(testData.userName));
    }
}