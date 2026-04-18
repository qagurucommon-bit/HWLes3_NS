package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsComponent {

    private final SelenideElement checkTable = $(".table-responsive");

    public void checkResult(String key, String value) {
        checkTable.$(byText(key))
                .parent()
                .shouldHave(text(value));
    }

}
