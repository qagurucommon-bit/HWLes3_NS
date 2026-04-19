package tests;

import org.junit.jupiter.api.Test;

public class TextBoxShort extends TestBase {

    @Test
    void successfulFillFormTest() {
        testBoxPage.openPage()
                .closeBanner()
                .typeUserName(testData.userName)
                .submitForm()
                .checkResult(testData.userName);
    }
}