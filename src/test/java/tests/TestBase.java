package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.DemoqaPage;
import pages.TestBoxPage;
import tests.testdata.TestData;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    DemoqaPage demoqaPage = new DemoqaPage();
    TestBoxPage testBoxPage = new TestBoxPage();
    TestData testData = new TestData();

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeAll
    static void setupSelenideEnv() {
        //   Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        //    Configuration.timeout = 10000; // default 4000
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    @AfterEach
    void closeDriver() {
        closeWebDriver();
    }
}