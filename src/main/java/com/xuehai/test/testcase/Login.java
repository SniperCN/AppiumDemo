package com.xuehai.test.testcase;

import com.alibaba.fastjson.JSONObject;
import com.xuehai.test.base.BaseCase;
import com.xuehai.test.pageobject.LoginPage;
import com.xuehai.test.utils.CommonUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName Login
 * @Description: 登录测试用例实现类
 * @Author Sniper
 * @Date 2019/5/23 13:09
 */
public class Login extends BaseCase {

    @Test(dataProvider = "data")
    public void login(Map<String, JSONObject> dataMap) {
        AppiumDriver<MobileElement> teacher = super.getDriverMap().get("teacher");
        LoginPage loginPage = new LoginPage(teacher, super.getSuiteName());
        JSONObject data = dataMap.get(CommonUtil.methodName());
        loginPage.login(data);
        loginPage.loginFailToastAssertion(data);
        loginPage.confirmError();
    }

    @DataProvider(name = "data")
    public Iterator<Object[]> dataProvider() {
        return super.dataProvider();
    }
}
