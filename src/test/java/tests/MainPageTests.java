package tests;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class MainPageTests extends TestBase {

    @Test
    @DisplayName("Verify that the main page content is correct")
    void mainPageContentTest() {
        step("Check the availability of the buttons in the gaming section - START/NEW GAME", () -> {
            $(AppiumBy.id("dev.lucanlm.antimine:id/continueGame")).shouldHave(text("START"));
            $(AppiumBy.id("dev.lucanlm.antimine:id/newGameShow")).shouldHave(text("NEW GAME"));
        });
        step("Check the availability of the buttons in the settings section - THEMES/CONTROLS/SETTINGS", () -> {
            $(AppiumBy.id("dev.lucanlm.antimine:id/themes")).shouldHave(text("THEMES"));
            $(AppiumBy.id("dev.lucanlm.antimine:id/controls")).shouldHave(text("CONTROLS"));
            $(AppiumBy.id("dev.lucanlm.antimine:id/settings")).shouldHave(text("SETTINGS"));
        });
        step("Check the availability of the buttons in the stats section - STATISTICS/PREVIOUS GAMES", () -> {
            $(AppiumBy.id("dev.lucanlm.antimine:id/stats")).shouldHave(text("STATISTICS"));
            $(AppiumBy.id("dev.lucanlm.antimine:id/previousGames")).shouldHave(text("PREVIOUS GAMES"));
        });
        step("Check the availability of the buttons in the about section - DONATION/TUTORIAL/LANGUAGE/ABOUT", () -> {
            $(AppiumBy.id("dev.lucanlm.antimine:id/removeAds")).shouldHave(text("DONATION"));
            $(AppiumBy.id("dev.lucanlm.antimine:id/tutorial")).shouldHave(text("TUTORIAL"));
            $(AppiumBy.id("dev.lucanlm.antimine:id/language")).shouldHave(text("LANGUAGE"));
            $(AppiumBy.id("dev.lucanlm.antimine:id/about")).shouldHave(text("ABOUT"));
        });
    }

    @Test
    @DisplayName("Verify that the ABOUT page content is correct")
    void aboutPageContentTest() {
        step("Open the ABOUT section", () -> {
            $(AppiumBy.id("dev.lucanlm.antimine:id/about")).click();
        });
        step("Verify that the ABOUT page has the app name", () -> {
            $(AppiumBy.id("dev.lucanlm.antimine:id/app_name")).shouldHave(text("ANTIMINE"));
        });
        step("Verify that the ABOUT page has the info about app version", () -> {
            $(AppiumBy.id("dev.lucanlm.antimine:id/version")).shouldHave(text("Version"));
        });
        step("Verify that the ABOUT page has credits to the artist", () -> {
            $(AppiumBy.id("dev.lucanlm.antimine:id/musicBy")).shouldHave(text("MUSIC BY TATYANA JACQUES"));
        });
        step("Verify that the ABOUT page has all the necessary buttons", () -> {
            $(AppiumBy.id("dev.lucanlm.antimine:id/thirdsParties")).shouldHave(text("LICENSES"));
            $(AppiumBy.id("dev.lucanlm.antimine:id/translation")).shouldHave(text("TRANSLATION"));
            $(AppiumBy.id("dev.lucanlm.antimine:id/sourceCode")).shouldHave(text("SOURCE CODE"));
        });
    }
}