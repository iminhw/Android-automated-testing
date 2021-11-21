package com.minhw;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.minhw.dto.DataList;
import com.minhw.page.MainPage;
import com.minhw.utils.GenerateInfo;
import com.minhw.utils.LoggerUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class MinhwTset {
    private static MainPage main;

//    @BeforeAll
//    public static void beforeAll() throws MalformedURLException {
//        main = new MainPage();
//    }

    /**
     * 参数配置
     *
     * @return
     * @throws IOException
     */
    static Stream<String> datas() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        DataList dataList = objectMapper.readValue(new File("src/test/resources/datas/data.yml"), DataList.class);
        System.out.println(dataList.getDataList().get(1));
        return dataList.getDataList().stream();
    }

//    @Test
//    void setMain() throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
//        DataList dataList = objectMapper.readValue(new File("src/test/resources/datas/data.yml"), DataList.class);
//        System.out.println(dataList);
//    }

    @ParameterizedTest
    @MethodSource("datas")
    void dataTest1(String data) {
        System.out.println("data:" + data);
        System.out.println("-----------------");
    }

    /**
     * 第一题 创建待办(通过右上角按钮进行创建)
     *
     * @param dataList
     */
    @ParameterizedTest
    @MethodSource("datas")
    void add_daiban1(String dataList) {
        String sentence = new GenerateInfo().get_sentence();
        LoggerUtil.logger.info(sentence);
        String result = main.toWorkbenchPage()
                .goto_schedule()
                .new_schedule()
                .edit_todolist(sentence)
                .edit_people()
                .search_people(dataList)
                .edit_datetime()
                .save()
                .get_todolist_page();
        assertThat(result, containsString(sentence));
    }

    /**
     * 第二题 下拉新建一个待办
     *
     * @param dataList
     */
    @ParameterizedTest
    @MethodSource("datas")
    void add_daiban2(String dataList) {
        String sentence = new GenerateInfo().get_sentence();
        LoggerUtil.logger.info(sentence);
        String result = main.toWorkbenchPage()
                .goto_schedule()
                .new_downSchedule()
                .edit_todolist(sentence)
                .edit_people()
                .search_people(dataList)
                .edit_datetime()
                .save()
                .get_todolist_page();
        assertThat(result, containsString(sentence));
    }

    /**
     * 第三题 添加多个待办
     *
     * @param dataList
     */
    @ParameterizedTest
    @MethodSource("datas")
    void add_daiban3(String dataList) {
//        /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView
        String result = main.toWorkbenchPage()
                .goto_schedule()
                .new_schedule()
                .edit_todolist("待办1")
                .edit_people()
                .search_people(dataList)
                .edit_datetime()
                .save()
                .new_schedule()
                .edit_todolist("待办2")
                .edit_people()
                .search_people(dataList)
                .edit_datetime()
                .save()
                .addScheTwo();
        LoggerUtil.logger.info(result);
        int rest = Integer.parseInt(result);
        if (rest >= 2) {
            LoggerUtil.logger.info("创建两个待办成功");
        }

    }

    /**
     * 第四题完成待办，在已完成待办列表进行断言
     */
    @Test
    void finsh_daian() {
        String result = main.toWorkbenchPage()
                .goto_schedule()
                .wancDaiban();
        LoggerUtil.logger.info(result);
    }

    /**
     * 删除待办
     */
    @Test
    void delete_daiban() {
        String result = main.toWorkbenchPage().goto_schedule().delectDaiban();
        LoggerUtil.logger.info(result);

    }

    /**
     * 取消在聊天列表顶部展示待办
     */
    @Test
    void quxiao_daiban() {
        String result = main.toWorkbenchPage().goto_schedule().quxiaoDaibanZS().quxiaoDuanyan();
        LoggerUtil.logger.info(result);
    }

    /**
     * 编辑待办进行断言
     */
    @Test
    void update_daiban() {
        String result = main.toWorkbenchPage().goto_schedule().goto_bianjDanban().updateSave();
        LoggerUtil.logger.info(result);
    }
}
