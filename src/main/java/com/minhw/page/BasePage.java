package com.minhw.page;

import com.minhw.utils.LoggerUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @program: minhwQTP
 * @description: BasePage
 * @author: MinHw or mz
 **/
public class BasePage {
    static BasePage instance = null;
    protected AppiumDriver driver;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
    }

    public BasePage() {
    }

    /**
     * @return instance
     */
    public static BasePage getInstance() {
        if (instance == null) {
            instance = new BasePage();
        }
        return instance;
    }

    /**
     * 睡眠3s
     */
    public static void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Integer> get() {
        ArrayList<Integer> size = new ArrayList<Integer>();
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
        size.add(height);
        size.add(width);
        return size;
    }

    /**
     * 选择
     *
     * @return 日期
     */
    public void tap_y(double percentage) {
        ArrayList<Integer> sizes = get();
        int height = sizes.get(0);
        int width = sizes.get(1);
        int point_X = width / 2;
        int point_Y = (int) (height * percentage);
        TouchAction ta = new TouchAction(driver);
        PointOption point_Concat = PointOption.point(point_X, point_Y);
        ta.press(point_Concat).release().perform();
    }

    /**
     * @param seconds 秒数
     * @param isTrue  ExpectedConditions.elementToBeClickable(by)
     */
    public void wait(int seconds, Function isTrue) {
        new WebDriverWait(driver, seconds).until(isTrue);
    }

    /**
     * @param isTrue
     */
    public void waitFun(Function isTrue) {
        new WebDriverWait(driver, 20).until(isTrue);
    }

    /**
     * @param by
     * @param timeout
     */
    public void waitClickable(By by, int timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(by));
    }

    /**
     * @param by
     */
    public void waitClickable(By by) {
        new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOfElementLocated(by));
        new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(by));
    }

    /**
     * @param by
     * @param timeout
     * @return
     */
    public WebElement findElement(By by, int timeout) {
        System.out.println(by);
        if (timeout > 0) {
            waitClickable(by, timeout);
            LoggerUtil.logger.info(by + " 元素状态为 : clickable");
        }
        return driver.findElement(by);
    }

    /**
     * @param by
     * @return
     */
    public WebElement findElement(By by) {
//        System.out.println(by);
        waitClickable(by);
        LoggerUtil.logger.info(by + " 元素状态为 : clickable");
        return driver.findElement(by);
    }

    public void waitLocated(By by) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /**
     * @param by
     * @return
     */
    public List<WebElement> findElements(By by) {
        System.out.println(by);
        waitClickable(by);
        LoggerUtil.logger.info(by + " 元素列表状态为 : clickable");
        return driver.findElements(by);
    }

    /**
     * @param by
     * @param timeout
     * @return
     */
    public List<WebElement> findElements(By by, int timeout) {
        System.out.println(by);
        if (timeout > 0) {
            waitClickable(by, timeout);
            LoggerUtil.logger.info(by + " 元素状态为 : clickable");
        }
        return driver.findElements(by);
    }

    /**
     * @param by
     * @param timeout
     */
    public void clickElement(By by, int timeout) {
        findElement(by, timeout).click();
    }


    /**
     * @param by
     */
    public void clickElement(By by) {
        findElement(by).click();
    }

    /**
     * @param by      元素定位
     * @param keyword 发送的内容
     */
    public void sendKey(By by, String keyword) {
        System.out.println("--------sendKeys----------------" + keyword);
//        System.out.println(driver.getPageSource());
//        runCmd("adb shell input text " + keyword);
        findElement(by).click();

        findElement(by).sendKeys(keyword);
    }

    public void sendKeyNoClick(By by, String keyword) {
        System.out.println("--------sendKeyNoClick----------------" + keyword);
        findElement(by).sendKeys(keyword);
    }

    /**
     * 滑动到元素可点击
     *
     * @param by  元素定位
     * @param num 最多滑动几次
     * @return
     */
    public void swipeFind(By by, int num) {
        WebElement element;
        LoggerUtil.logger.info("开始进行滑动查找元素：" + by);
        for (int i = 1; i < num; i++) {
            try {
                LoggerUtil.logger.info("第" + i + "次滑动查找元素：" + by);
                element = driver.findElement(by);
            } catch (Exception e) {
                LoggerUtil.logger.info("第" + i + "次滑动查找元素：" + by + "未找到；");
                swipeUp();
            }
            if (i == num - 1) {
                LoggerUtil.logger.error("找了 " + i + " 次，未找到:", new NoSuchElementException("Custom exception"));
            }
        }
    }

    /**
     * 滑动到元素可点击
     * 最多滑动5次
     *
     * @param by 元素定位
     * @return
     */
    public void swipeFind(By by) {
        LoggerUtil.logger.info("开始进行滑动查找元素：" + by);
        WebElement element = null;
        for (int i = 1; i < 5; i++) {
            try {
                element = driver.findElement(by);
            } catch (NoSuchElementException e) {
                LoggerUtil.logger.info("第" + i + "次滑动查找元素：" + by + "未找到；");
                swipeUp();
            }
            if (i == 4 && element == null) {
                LoggerUtil.logger.error("找了 " + i + " 次，未找到:", new NoSuchElementException("Custom exception"));
            }

        }

    }

    /**
     * 向上滑动
     */
    public void swipeUp() {
        LoggerUtil.logger.info("进行向上滑动");
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();

        String start_x = String.valueOf(width * 0.72);
        String start_y = String.valueOf(height * 0.78);
        String end_x = start_x;
        String end_y = String.valueOf(height * 0.3);
        LoggerUtil.logger.info("从坐标点" + start_x + "，" + start_y + " 滑动到坐标点：" + end_x + "，" + end_y);
        appiumSwipe(start_x, start_y, end_x, end_y);
    }

    /**
     * 向下滑动
     */
    public void swipeDown() {
        LoggerUtil.logger.info("进行向下滑动");
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();

        String start_x = String.valueOf(width / 2);
        String start_y = String.valueOf(height / 4);
        String end_x = start_x;
        String end_y = String.valueOf(height * 1 / 4);
        LoggerUtil.logger.info("从坐标点" + start_x + "，" + start_y + " 滑动到坐标点：" + end_x + "，" + end_y);
        appiumSwipe(start_x, start_y, end_x, end_y);
    }

    /**
     * ****************************appium实现手势动作*******************
     */
    /**
     * appium基于长按+移动实现滑动
     *
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     */
    public void appiumSwipe(String startX, String startY, String endX, String endY) {
        try {
            TouchAction action = new TouchAction(driver);
            //学会通过源码学习如何使用方法。
            PointOption startpoint = PointOption.point((int) Double.parseDouble(startX), (int) Double.parseDouble(startY));
            PointOption endPoint = PointOption.point((int) Double.parseDouble(endX), (int) Double.parseDouble(endY));
            //通过拼接长按和移动方法完成swipe动作。
            action.longPress(startpoint).moveTo(endPoint).release().perform();
            Thread.sleep(3000);
        } catch (NumberFormatException | InterruptedException e) {
            LoggerUtil.logger.error(e, e.fillInStackTrace());
            LoggerUtil.logger.error("滑动操作失败");
        }


    }


    /**
     * 实现长按某个元素
     *
     * @param by   元素定位
     * @param time 长按时间
     */
    public void appiumHoldEl(By by, String time) {
        try {
            int t = Integer.parseInt(time);
            Duration last = Duration.ofSeconds(t);
            TouchAction action = new TouchAction(driver);
            // 定位到一个元素，并且在该元素上长按指定的时长
            action.longPress(LongPressOptions.longPressOptions()
                            .withElement(ElementOption.element(findElement(by))).withDuration(last))
                    .waitAction(WaitOptions.waitOptions(last)).release().perform();
        } catch (NumberFormatException e) {
            LoggerUtil.logger.error("执行Appium滑动方法失败");
            LoggerUtil.logger.error(e, e.fillInStackTrace());
        }
    }

    public String page() {
        return driver.getPageSource();

    }

    public void quit() {
        driver.quit();
    }
}
