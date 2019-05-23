package com.xuehai.test.pageobject;

import com.alibaba.fastjson.JSONObject;
import com.xuehai.test.base.AppiumAssertion;
import com.xuehai.test.base.AppiumBasePage;
import com.xuehai.test.base.AssertionCommand;
import com.xuehai.test.model.Locator;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @ClassName LoginPage
 * @Description: 登录页面
 * @Author Sniper
 * @Date 2019/5/23 13:06
 */
public class LoginPage extends AppiumBasePage {
    private AppiumDriver<MobileElement> driver;
    private Locator userName;
    private Locator password;
    private Locator submit;
    private Locator errorBox;

    public LoginPage(AppiumDriver<MobileElement> driver, String suiteName) {
        super(driver, suiteName);
        this.driver = driver;
        userName = super.getLocator("userName");
        password = super.getLocator("password");
        submit = super.getLocator("submit");
        errorBox = super.getLocator("errorBox");
    }

    public void login(JSONObject data) {
        String username = data.getString("userName");
        String pwd = data.getString("password");
        super.sendKeys(userName, username);
        super.sendKeys(password, pwd);
        super.click(submit);
    }

    public void loginFailToastAssertion(JSONObject data) {
        AssertionCommand command = new AssertionCommand(data.getString("loginAssertion"));
        boolean result = AppiumAssertion.assertion(driver, command);
    }

    public void confirmError() {
        super.click(errorBox);
    }
}
