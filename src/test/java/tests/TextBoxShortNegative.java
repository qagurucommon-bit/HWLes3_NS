package tests;

import org.junit.jupiter.api.Test;

import static tests.testdata.TestData.errorUserEmail;

public class TextBoxShortNegative extends TestBase {

    @Test
    void negativeFormTest() {
        testBoxPage.openPage()
                .closeBanner()
                .typeUserEmail(errorUserEmail)
                .submitForm()

                //проверка результатов
                .checkResultNotOpened();
    }
}