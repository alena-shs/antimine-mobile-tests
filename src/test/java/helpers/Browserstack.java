package helpers;

import config.AuthConfig;
import org.aeonbits.owner.ConfigFactory;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class Browserstack {
    public static AuthConfig authConfig = ConfigFactory.create(AuthConfig.class,
            System.getProperties());
    public static String getVideoUrl(String sessionId) {
        System.out.println("Video attachment initiated");
        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .log().all()
                .filter(withCustomTemplates())
                .auth().basic(authConfig.getUser(), authConfig.getPassword())
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}