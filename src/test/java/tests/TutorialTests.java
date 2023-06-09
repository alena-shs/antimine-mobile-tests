package tests;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Story("Tutorial tests")
@Owner("Alena Shomanova")
public class TutorialTests extends TestBase {
    @Test
    @DisplayName("Verify that tutorial page content is correct")
    void tutorialContentTest() {
        step("Open the TUTORIAL section", () -> {
            $(AppiumBy.id("dev.lucanlm.antimine:id/tutorial")).click();
            System.out.println("OPENED TUTORIAL PAGE");
        });
        step("Verify that the TUTORIAL page has all the necessary images", () -> {
            $(AppiumBy.id("dev.lucanlm.antimine:id/image")).shouldBe(visible);
            $(AppiumBy.id("dev.lucanlm.antimine:id/image2")).shouldBe(visible);
            $(AppiumBy.id("dev.lucanlm.antimine:id/image3")).shouldBe(visible);
        });
        step("Verify that the TUTORIAL page has all the necessary text", () -> {
            $(AppiumBy.id("dev.lucanlm.antimine:id/basic"))
                    .shouldHave(text("The rule of the game is simple, the number on a square shows the number of mines adjacent to it and you have to flag all the mines."));
            $(AppiumBy.id("dev.lucanlm.antimine:id/text1"))
                    .shouldHave(text("If a number is touching the same number of squares, then the squares are all mines."));
            $(AppiumBy.id("dev.lucanlm.antimine:id/text2"))
                    .shouldHave(text("After marking your first flag, review the numbers and analyze the next square."));
        });
    }

    @Test
    @DisplayName("Verify that a new game can be started directly from tutorial")
    void gameTutorialStartTest() {
        step("Open the TUTORIAL section", () ->
                $(AppiumBy.id("dev.lucanlm.antimine:id/tutorial")).click());
        step("Start a game from the tutorial page", () ->
                $(AppiumBy.id("dev.lucanlm.antimine:id/playGame")).click());
        step("Verify that the game started", () ->
            $(AppiumBy.id("dev.lucanlm.antimine:id/tapToBegin")).should(exist));
        step("Verify that the started game is on EASY MODE", () ->
            $(AppiumBy.id("dev.lucanlm.antimine:id/minesCount")).shouldHave(text("10")));
    }
}
