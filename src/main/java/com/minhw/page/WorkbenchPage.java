package com.minhw.page;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

/**
 * @program: minhwQTP
 * @description:
 * @author: MinHw or mz
 * @create: 2021-11-18 08:39
 **/
public class WorkbenchPage extends BasePage {
    private By schedule = By.xpath("//*[@text='日程']");

    public WorkbenchPage(AppiumDriver driver) {
        super(driver);
    }

    public SchedulePage goto_schedule() {
        swipeFind(schedule);
        clickElement(schedule);
        return new SchedulePage(driver);
    }
}
