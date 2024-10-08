package pages;

import com.microsoft.playwright.Locator;
import context.TestContext;
import io.qameta.allure.Step;
import utils.ConfigurationReader;

public class LoginPage {

    TestContext context;
    public Locator usernameInput;
    public Locator passwordInput;
    public Locator loginButton;
    public Locator footer;

    public LoginPage(TestContext context){
        this.context = context;
        this.usernameInput = context.page.locator("#user-name");
        this.passwordInput = context.page.locator("#password");
        this.loginButton = context.page.locator("#login-button");
        this.footer = context.page.locator(".footer_copy");
    }

    @Step("Вход в систему как стандартный пользователь")
    public LoginPage loginAsStandardUser() {
       return loginAs(ConfigurationReader.get("standard_login"), ConfigurationReader.get("password"));
    }

    private LoginPage loginAs(String standardLogin, String password) {
        usernameInput.fill(standardLogin);
        passwordInput.fill(password);
        loginButton.click();
        return this;
    }

}
