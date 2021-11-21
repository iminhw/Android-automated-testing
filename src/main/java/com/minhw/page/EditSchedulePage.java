package com.minhw.page;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

/**
 * @program: minhwQTP
 * @description:
 * @author: MinHw or mz
 * @create: 2021-11-18 08:56
 **/
public class EditSchedulePage extends BasePage {
    By _edit_todolist_element = By.xpath("//*[@class='android.widget.EditText']");
    By _participants_element = By.xpath("//*[@text='参与人']");
    By _remind_me_element = By.xpath("//*[@text='提醒我']");
    By _confirm_element = By.xpath("//*[@text='确定']");
    By _save_element = By.xpath("//*[@text='保存']");

    //    /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.TextView
    By _upDate_black_element = By.id("com.tencent.wework:id/ivv");
    ///hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.EditText
    By _edit_ipt_element = By.id("com.tencent.wework:id/it4");

    public EditSchedulePage(AppiumDriver driver) {
        super(driver);
    }

    public EditSchedulePage edit_todolist(String todo_text) {
//        编辑待办事项内容
        waitLocated(_edit_todolist_element);
        sendKey(_edit_todolist_element, todo_text);
        return this;
    }

    public ChoolsePage edit_people() {
        //编辑人员
        clickElement(_participants_element);
        return new ChoolsePage(driver);
    }

    public EditSchedulePage edit_datetime() {
        //点击 提醒我
        clickElement(_remind_me_element);
        sleep();
        //选择一个日期
        tap_y(0.8);
//        向上滑动 选择时间
        swipeUp();
        //点击 确定
        clickElement(_confirm_element);
        return this;
    }

    public SchedulePage save() {
        //  保存
        clickElement(_save_element);
        return new SchedulePage(driver);
    }
//    public EditSchedulePage saveRtThis() {
//        //  保存
//        clickElement(_save_element);
//        return this;
//    }

    public String updateSave() {
        clickElement(_edit_ipt_element);
        sendKeyNoClick(_edit_todolist_element, "-update");
        clickElement(_upDate_black_element);
        return page();
    }

}
