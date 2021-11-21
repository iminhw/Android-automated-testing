package com.minhw.page;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

/**
 * @program: minhwQTP
 * @description:
 * @author: MinHw or mz
 * @create: 2021-11-18 08:41
 **/
public class SchedulePage extends BasePage {
    //    By daiban = By.xpath("//*[@text='待办']");
    By daiban = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.TextView");
    //    By daiban = By.xpath("//*[@resource-id=\"com.tencent.wework:id/f02\"]");
    By _add_icon_element = By.id("com.tencent.wework:id/iwf");

    By wancDaiban = By.xpath("//*[@text='显示已完成事项']");

    By holeEl = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");
    By dtIco = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.ImageView");
    By closeDT = By.id("com.tencent.wework:id/ivv");
//    /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView

    By sandianIco = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.TextView");
    By quxiao = By.xpath("//*[@text='取消在聊天列表顶部展示']");

    By blackWork = By.id("com.tencent.wework:id/ivv");
    By xiaoX = By.xpath("//*[@text='消息']");
    //    com.tencent.wework:id/itp
    By xiaoxDB = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[2]");

    By editDB = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");

    By daibanTitle = By.id("com.tencent.wework:id/ivw");
//    /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView

    public SchedulePage(AppiumDriver driver) {
        super(driver);
    }

    public EditSchedulePage new_schedule() {
        //切换到待办
        clickElement(daiban);
        //新建日程
        waitLocated(_add_icon_element);
        clickElement(_add_icon_element);
        return new EditSchedulePage(driver);
    }

    /**
     * 下拉新建一个待办
     */
    public EditSchedulePage new_downSchedule() {
        // 向下滑动创建
//        appiumSwipe("360", "216", "352", "664");
        appiumSwipe("300", "300", "300", "600");
        //新建日程
        waitLocated(_add_icon_element);
        clickElement(_add_icon_element);
        return new EditSchedulePage(driver);
    }

    /**
     * @return
     */
    public String wancDaiban() {
        try {
            findElements(wancDaiban);
            clickElement(wancDaiban);
        } catch (Exception e) {

        }
        return page();
    }

    public String delectDaiban() {
//        长按2s进入删除
        appiumHoldEl(holeEl, "2");
//        findElement(dtIco);
        clickElement(dtIco);
//        sleep();
        clickElement(closeDT);
        return page();
    }

    public SchedulePage quxiaoDaibanZS() {
        clickElement(sandianIco);
        findElement(quxiao);
        clickElement(quxiao);
        return this;
    }

    public String quxiaoDuanyan() {
        clickElement(blackWork);
        clickElement(xiaoX);
//        /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout
        try {
            findElement(xiaoxDB);
        } catch (Exception e) {
            return "取消待办在聊天列表顶部展示失败";
        }
        return "取消待办在聊天列表顶部展示成功";
    }

    public EditSchedulePage goto_bianjDanban() {
        findElement(editDB);
        clickElement(editDB);
        return new EditSchedulePage(driver);
    }

    public String addScheTwo() {
        String text = findElement(daibanTitle).getAttribute("text");
        System.out.println(text);
        System.out.println(text.substring(text.length() - 1));
        return text.substring(text.length() - 1);
    }


    public String get_todolist_page() {
//        获取页面内容
        return page();
    }

    /**
     * 断言待办数量
     */
    public String get_todolist_num() {
        return page();
    }
}
