package com.minhw.page;

import com.minhw.DriverFactory;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

/**
 * @program: minhwQTP
 * @description: 主入口
 * @author: MinHw or mz
 * @create: 2021-11-17 18:53
 **/
public class MainPage extends BasePage {
    private By work = By.xpath("//*[@text='工作台']");

    public MainPage(AppiumDriver driver) {
        super(driver);
    }

    public MainPage() throws MalformedURLException {
        driver = (AppiumDriver) DriverFactory.getInstance().createDriver();
        waitClickable(work, 120);
    }

    /**
     * 要执行的下一个页面
     *
     * @return
     */
    public WorkbenchPage toWorkbenchPage() {
        clickElement(work);
        return new WorkbenchPage(driver);
    }

}
