package pages;

import com.microsoft.playwright.Locator;
import context.TestContext;

public class MainPage {
    TestContext context;
    public Locator addToCartButtons;
    public Locator cartCounter;

    public MainPage(TestContext context){
        this.context = context;
        this.addToCartButtons = context.page.locator(".btn_inventory");
        this.cartCounter = context.page.getByTestId("shopping-cart-badge");
    }

    public MainPage clickAllAddToCartButtons(){
        addToCartButtons.all().forEach(Locator::click);
        return this;
    }
}
