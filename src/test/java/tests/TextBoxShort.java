package tests;

import org.junit.jupiter.api.Test;

import static tests.testdata.TestData.userName;

public class TextBoxShort extends TestBase {

    @Test
    void successfulFillFormTest() {
        testBoxPage.openPage()
                .closeBanner()
                .typeUserName(userName)
                .submitForm()

                //проверка результатов
                .checkResult(userName);
    }
}