package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.DemoqaPage;
import pages.TestBoxPage;
import tests.testdata.TestData;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    DemoqaPage demoqaPage = new DemoqaPage();
    TestBoxPage testBoxPage = new TestBoxPage();
    TestData testData = new TestData();

    @BeforeEach
    void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeAll
    static void setupSelenideEnv() {
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "128.0");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.baseUrl = System.getProperty("baseUrl", "https://demoqa.com");
        Configuration.headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
        Configuration.remote = System.getProperty("remote");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.attachAsText("Some file", "Some content");
        Attach.browserConsoleLogs();
        Attach.addVideo();

        closeWebDriver();
    }
}