package com.minhw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


/**
 * @author mz
 */
public class DriverFactory {
    private static DriverFactory instance;

    public static DriverFactory getInstance() {
        if (instance == null) {
            instance = new DriverFactory();
        }
        return instance;
    }

    public WebDriver createDriver() throws MalformedURLException {
        WebDriver driver = null;
//        emulator-5554
        String deviceName = "Android Emulator";
//        app配置
//        adb shell dumpsys window w |grep \/ |grep name=
        String appPkg = "com.tencent.wework";
        String appAct = ".launch.WwMainActivity";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("platformVersion", "6.0.1");
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("appPackage", appPkg);
        capabilities.setCapability("appActivity", appAct);
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("skipDeviceInitialization", true);
        // 设置使用unicode键盘，支持输入中文和特殊字符
        capabilities.setCapability("unicodeKeyboard", "true");
        // 设置用例执行完成后重置键盘
        capabilities.setCapability("resetKeyboard", "true");
        /* http://127.0.0.1:4723/wd/hub */
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        return driver;
    }
}
