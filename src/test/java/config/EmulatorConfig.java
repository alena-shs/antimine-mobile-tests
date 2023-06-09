package config;

import org.aeonbits.owner.Config;

@Config.Sources(
        "classpath:properties/emulator.properties"
)

public interface EmulatorConfig extends Config {

    @Config.Key("deviceName")
    @Config.DefaultValue("Pixel 4 API 30")
    String getDeviceName();

    @Config.Key("platformVersion")
    @Config.DefaultValue("11.0")
    String getPlatformVersion();

    @Config.Key("appPackage")
    @Config.DefaultValue("dev.lucasnlm.antimine")
    String getAppPackage();

    @Config.Key("appActivity")
    @Config.DefaultValue("dev.lucasnlm.antimine.main.MainActivity")
    String getAppActivity();

    @Config.Key("serverUrl")
    @Config.DefaultValue("http://localhost:4723/wd/hub")
    String getServerUrl();

    @Config.Key("appUrl")
    @Config.DefaultValue("https://github.com/lucasnlm/antimine-android/releases/tag/17.2.2/app-foss-release.apk")
    String getAppUrl();

    @Config.Key("appPath")
    @Config.DefaultValue("src/test/resources/apps/app-foss-release.apk")
    String getAppPath();
}