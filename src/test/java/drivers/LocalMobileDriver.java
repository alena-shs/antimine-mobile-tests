package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConfig;
import config.EmulatorConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;
import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class LocalMobileDriver implements WebDriverProvider {
    public static EmulatorConfig config = ConfigFactory.create(EmulatorConfig.class,
            System.getProperties());
    public static URL getAppiumServerUrl() {
        try {
            return new URL(config.getServerUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        System.out.println(config.getAppActivity());
        System.out.println(config.getAppPackage());
        System.out.println(config.getServerUrl());
        System.out.println(config.getDeviceName());
        System.out.println(config.getAppPath());
        System.out.println(config.getPlatformVersion());
        System.out.println(config.getAppUrl());
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(ANDROID)
                .setDeviceName(config.getDeviceName())
                .setPlatformVersion(config.getPlatformVersion())
                .setApp(getAppPath())
                .setAppPackage(config.getAppPackage())
                .setAppActivity(config.getAppActivity());

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    private String getAppPath() {
        String appUrl = config.getAppUrl();
        String appPath = config.getAppPath();

        File app = new File(appPath);
        if (!app.exists()) {
            try (InputStream in = new URL(appUrl).openStream()) {
                copyInputStreamToFile(in, app);
            } catch (IOException e) {
                throw new AssertionError("Failed to download application", e);
            }
        }
        return app.getAbsolutePath();
    }
}