package tests;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import utils.ConfigurationReader;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTest extends TestBase {

    @Test
    public void successLoginTest() {
        context.page.navigate(ConfigurationReader.get("base_url"));
        Locator footer = new LoginPage(context).loginAsStandardUser().footer;
        assertThat(footer).containsText("Sauce Labs");
    }
}
