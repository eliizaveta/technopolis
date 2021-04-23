import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MessagePage {

    WebDriver driver;

    private final String MSG_LOCATOR = ".//div[@id = 'msg_toolbar_button']";
    private final String PLUS_BUTTON = "msg-button[data-tsid='open_plus_button']";
    private final String CREATE_CHAT_BUTTON = "msg-menu-item[data-tsid='plus_create_chat']";
    private final String CREATE_EMPTY_CHAT_BUTTON = "msg-button[data-tsid='finish_create_chat_button']";
    private final String OPEN_STICKERS_BUTTON = "msg-button[data-tsid='open_smiles_button']";
    private final String POPULAR_STICKER1 = "msg-assets-sticker[set-id='popular_stickers']";
    private final String MSG_CONTAINER = "msg-message-container";
    private final String ACTIONS_WITH_MSG_BUTTON = "msg-button[data-tsid='more_message']";
    private final String DELETE_MSG_BUTTON = "msg-tico[data-tsid='remove_msg_button']";
    private final String CONFIRM_PRIMARY = "msg-button[data-tsid='confirm-primary']";
    private final String CHAT_INFO_BUTTON = "msg-button[data-tsid='chat_info_button']";
    private final String LEAVE_CHAT_BUTTON = "msg-tico[data-tsid='leave-chat-btn']";
    private final String ROOT_ID = "msg_layer";

    MessagePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToMSG() {
        driver.findElement(By.xpath(MSG_LOCATOR)).click();
    }

    private WebElement findShadowDomRoot() {
        WebElement root = driver.findElement(By.id(ROOT_ID));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement shadowDom = (WebElement) js.executeScript("return arguments[0].shadowRoot", root);
        return shadowDom;
    }

    public void clickOnElement(WebElement shadowDom, String css) {
        shadowDom.findElement(By.cssSelector(css)).click();
    }

    public void createEmptyChat() {
        WebElement shadowDom = findShadowDomRoot();
        clickOnElement(shadowDom, PLUS_BUTTON);
        clickOnElement(shadowDom, CREATE_CHAT_BUTTON);
        clickOnElement(shadowDom, CREATE_EMPTY_CHAT_BUTTON);
    }

    public void sendSticker() {
        WebElement shadowDom = findShadowDomRoot();
        clickOnElement(shadowDom, OPEN_STICKERS_BUTTON);
        clickOnElement(shadowDom, POPULAR_STICKER1);
    }

    public void deleteMSG() {
        WebElement shadowDom = findShadowDomRoot();
        Actions action = new Actions(driver);
        action.moveToElement(shadowDom.findElement(By.cssSelector(MSG_CONTAINER))).build().perform();

        clickOnElement(shadowDom, ACTIONS_WITH_MSG_BUTTON);
        clickOnElement(shadowDom, DELETE_MSG_BUTTON);
        clickOnElement(shadowDom, CONFIRM_PRIMARY);
    }

    public void deleteChat() {
        WebElement shadowDom = findShadowDomRoot();
        clickOnElement(shadowDom, CHAT_INFO_BUTTON);
        clickOnElement(shadowDom, LEAVE_CHAT_BUTTON);
        clickOnElement(shadowDom, CONFIRM_PRIMARY);
    }
}