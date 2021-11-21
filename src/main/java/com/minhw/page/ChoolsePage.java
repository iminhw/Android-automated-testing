package com.minhw.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.functions.ExpectedCondition;
import org.openqa.selenium.By;

/**
 * @program: minhwQTP
 * @description:
 * @author: MinHw or mz
 * @create: 2021-11-18 08:59
 **/
public class ChoolsePage extends BasePage {
    By _search_icon_element = By.xpath("//*[@text='选择参与人']/../../../../following-sibling::android.widget.LinearLayout//*[@class='android.widget.TextView']");
    By _search_box_element = By.xpath("//*[@text='搜索']");
    By _confirm_element = By.xpath("//*[contains(@text, \"确定\")]");

    public ChoolsePage(AppiumDriver driver) {
        super(driver);
    }


    public EditSchedulePage search_people(String people) {
        // 点击 搜索 按钮
        clickElement(_search_icon_element);
        // 输入 搜索内容 比如 hogwarts(联系人有这个名字)
        sendKey(_search_box_element, people);
        By _search_result_element = By.xpath("//*[contains(@text, " + people + ")]");
        waitFun((ExpectedCondition<Boolean>) index -> {
            return (findElements(_search_result_element).size() - 1) > 1;
        });

        clickElement(_search_result_element, 1);
        clickElement(_confirm_element);
        return new EditSchedulePage(driver);

    }
}
