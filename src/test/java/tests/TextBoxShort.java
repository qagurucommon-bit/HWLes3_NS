package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Story("Short TestBox Registration form")
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