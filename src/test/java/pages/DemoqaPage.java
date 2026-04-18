package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsComponent registrationResultsComponent = new RegistrationResultsComponent();

    //elements
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement userNumberInput = $("#userNumber");
    private final SelenideElement dateOfBirthSelect = $("#dateOfBirthInput");
    private final SelenideElement userGenderContainer = $("#genterWrapper");
    private final SelenideElement userSubjectsInput = $("#subjectsInput");
    private final SelenideElement userHobbies = $("#hobbiesWrapper");
    private final SelenideElement userPicture = $("#uploadPicture");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement stateSelect = $("#state");
    private final SelenideElement citySelect = $("#city");
    private final SelenideElement stateCitySelect = $("#stateCity-wrapper");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement modalDialogPopup = $(".modal-dialog");
    private final SelenideElement modalContent = $(".modal-content");
    private final SelenideElement closeModalButton = $("#closeLargeModal");


    //actions
    public DemoqaPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    public DemoqaPage closeBanner() {
        executeJavaScript("""
                      document.getElementById('fixedban')?.remove();
                     document.querySelector('footer')?.remove();
                """);

        return this;
    }

    public DemoqaPage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public DemoqaPage typeLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public DemoqaPage typeEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public DemoqaPage typeUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public DemoqaPage setGender(String value) {
        userGenderContainer.$(byText(value)).click();

        return this;
    }

    public DemoqaPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthSelect.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public DemoqaPage typeSubjectInput(String value) {
        userSubjectsInput.setValue(value).pressEnter();

        return this;
    }

    public DemoqaPage setHobbies(String value) {
        userHobbies.$(byText(value)).click();

        return this;
    }

    public DemoqaPage uploadPicture(String value) {
        userPicture.uploadFromClasspath(value);

        return this;
    }

    public DemoqaPage typeCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public DemoqaPage setState(String value) {
        stateSelect.click();
        stateCitySelect.$(byText(value)).click();

        return this;
    }

    public DemoqaPage setCity(String value) {
        citySelect.click();
        stateCitySelect.$(byText(value)).click();

        return this;
    }

    public DemoqaPage setStateAndCity(String state, String city) {
        setState(state);
        setCity(city);

        return this;
    }

    public DemoqaPage submitForm() {
        submitButton.click();

        return this;
    }

    public DemoqaPage modalDialogOpen() {
        modalDialogPopup.shouldBe(visible);

        return this;
    }

    public DemoqaPage modalDialogNotOpen() {
        modalDialogPopup.shouldNotBe(visible);

        return this;
    }

    public DemoqaPage checkTitle(String value) {
        modalContent.shouldHave(text(value));

        return this;
    }

    public DemoqaPage checkResult(String key, String value) {
        registrationResultsComponent.checkResult(key, value);
        return this;
    }

    public DemoqaPage closeModal() {
        closeModalButton.click();
        return this;
    }

}