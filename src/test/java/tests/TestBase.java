package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
//import drivers.BrowserstackMobileDriver;
import drivers.BrowserstackMobileDriver;
import drivers.LocalMobileDriver;
import helpers.Attach;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {
    public static String env = System.getProperty("env");

    @BeforeAll
    public static void setup() {
        if (env == null) {
            env = "emulator";
        }

        switch (env) {
            case "emulator":
                Configuration.browser = LocalMobileDriver.class.getName();
                break;
            case "browserstack":
                Configuration.browser = BrowserstackMobileDriver.class.getName();
                break;
        }
        Configuration.browserSize = null;
    }


    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
        $(AppiumBy.className("android.widget.TextView")).click();
    }

    @AfterEach
    void afterEach() {
        String sessionId = sessionId().toString();
//        Attach.screenshotAs("Last screenshot"); // todo
        Attach.pageSource();

        closeWebDriver();
        switch (env) {
            case "browserstack":
                Attach.addVideo(sessionId);
                break;
        }
    }

}