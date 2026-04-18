package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TestBoxPage {

    //elements
    private final SelenideElement userNameInput = $("#userName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement resultBlock = $("#output");

    //actions
    public TestBoxPage openPage() {
        open("/text-box");

               return this;
    }

    public TestBoxPage closeBanner() {
        executeJavaScript("""
                      document.getElementById('fixedban')?.remove();
                     document.querySelector('footer')?.remove();
                """);

        return this;
    }

    public TestBoxPage typeUserName(String value) {
        userNameInput.setValue(value);

        return this;
    }

    public TestBoxPage typeUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public TestBoxPage submitForm() {
        submitButton.click();

        return this;
    }

    public TestBoxPage checkResult(String value) {
        resultBlock.shouldHave(text(value));

        return this;
    }

    public TestBoxPage checkResultNotOpened() {
        resultBlock.shouldNotBe(visible);

        return this;
    }
}
