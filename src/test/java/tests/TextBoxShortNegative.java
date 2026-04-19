package tests;

import org.junit.jupiter.api.Test;

public class TextBoxShortNegative extends TestBase {

    @Test
    void negativeFormTest() {
        testBoxPage.openPage()
                .closeBanner()
                .typeUserEmail(testData.errorUserEmail)
                .submitForm()
                .checkResultNotOpened();
    }
}