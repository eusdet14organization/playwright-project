package tests;

import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;
import utils.ConfigurationReader;

public class MainPageTests extends TestBase {

    @Test
    public void addAllItemsTest() {
        context.page.navigate(ConfigurationReader.get("base_url"));
        new LoginPage(context).loginAsStandardUser().footer.textContent();
        String count = new MainPage(context).clickAllAddToCartButtons().cartCounter.textContent();
        Assertions.assertEquals(6, Integer.parseInt(count));
    }
}
