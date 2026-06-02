package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TestBoxPage {

    //elements
    private final SelenideElement userNameInput = $("#userName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement resultBlock = $("#output");

    //actions
    @Step("Open Registration Page")
    public TestBoxPage openPage() {
        open("/text-box");

               return this;
    }

    @Step("Close Banner")
    public TestBoxPage closeBanner() {
        executeJavaScript("""
                      document.getElementById('fixedban')?.remove();
                     document.querySelector('footer')?.remove();
                """);

        return this;
    }

    @Step("Type User Name \"{value}\"")
    public TestBoxPage typeUserName(String value) {
        userNameInput.setValue(value);

        return this;
    }

    @Step("Type User Email \"{value}\"")
    public TestBoxPage typeUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    @Step("Press Submit Button")
    public TestBoxPage submitForm() {
        submitButton.click();

        return this;
    }

    @Step("Check That Results Has \"{value}\"")
    public TestBoxPage checkResult(String value) {
        resultBlock.shouldHave(text(value));

        return this;
    }

    @Step("Checking Results Not Opened")
    public TestBoxPage checkResultNotOpened() {
        resultBlock.shouldNotBe(visible);

        return this;
    }
}
