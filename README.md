# minhwQTP

#### 介绍
   一个测试企业微信的安卓移动应用测试入门程序。
    1. 因为当时不知道安卓的key，所以使用了最**的xpath来定位元素。
    2. 
#### 软件架构
    见pom.xml


#### 常用命令记录

```bash
adb logcat> log.txt 
#下面命令 先打开哟啊查看的app
adb shell dumpsys window w |grep \/ |grep name=

adb kill-server
adb start-server
adb devices

```
```java
        capabilities.setCapability("platformVersion", “6.0.1”);

       capabilities.setCapability("platformVersion", "6.0.1");
        capabilities.setCapability("appPackage", "com.tencent.wework");
        capabilities.setCapability("appActivity", "com.android.provision/.DefaultActivity");
```
XPath 是一种特殊的路径，可以理解为使用多个参数来唯一定位到一个控 件。
        在此处我们使用的 XPath 为//android.widget.TextView[@text='鲜切花 ']，即 其格式如下。
//控件类名[@控件属性名='控件属性值']


//android.widget.TextView[@text='日程']
