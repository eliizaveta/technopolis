import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class NewPage {

    WebDriver driver;

    private String MSG_LOCATOR = ".//div[@id = 'msg_toolbar_button']";

    NewPage(WebDriver driver) {
        this.driver = driver;
        check();
    }

    protected void check() {

    }

    public UserPage goToMSG() throws InterruptedException
    {
        Thread.sleep(4);
        driver.findElement(By.xpath(MSG_LOCATOR)).click();
        return new UserPage(driver);
    }
    public UserPage clickAddTextChatButton() throws InterruptedException{
        WebElement root = driver.findElement(By.id("msg_layer"));
        Thread.sleep(300);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement shadowDom = (WebElement) js.executeScript("return arguments[0].shadowRoot", root);
        WebElement buttonplus = shadowDom.findElement(By.cssSelector("msg-button[data-tsid='open_plus_button']"));
        buttonplus.click();
        Thread.sleep(400);
        WebElement createChatButton = shadowDom.findElement(By.cssSelector("msg-menu-item[data-tsid='plus_create_chat']"));
        createChatButton.click();
        Thread.sleep(400);
        WebElement createEmptyChatButton = shadowDom.findElement(By.cssSelector("msg-button[data-tsid='finish_create_chat_button']"));
        createEmptyChatButton.click();
        Thread.sleep(400);
        return new UserPage(driver);
    }

    public UserPage sendMSG() throws InterruptedException{
        WebElement root = driver.findElement(By.id("msg_layer"));
        Thread.sleep(300);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement shadowDom = (WebElement) js.executeScript("return arguments[0].shadowRoot", root);
        WebElement inputMSG = shadowDom.findElement(By.cssSelector("msg-button[data-tsid='open_smiles_button']"));
        inputMSG.click();
        Thread.sleep(400);
        WebElement sticker = shadowDom.findElement(By.cssSelector("msg-assets-sticker[set-id='popular_stickers']"));
        sticker.click();
        Thread.sleep(400);
        return new UserPage(driver);
    }
    //
    public UserPage deleteChat() throws InterruptedException{
        WebElement root = driver.findElement(By.id("msg_layer"));
        Thread.sleep(300);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement shadowDom = (WebElement) js.executeScript("return arguments[0].shadowRoot", root);


        WebElement msgBox = shadowDom.findElement(By.cssSelector("msg-message-container"));
        Actions action = new Actions(driver);
        action.moveToElement(msgBox).build().perform();
        WebElement moreAct = shadowDom.findElement(By.cssSelector("msg-button[data-tsid='more_message']"));
        moreAct.click();
        Thread.sleep(2000);
        WebElement delM = shadowDom.findElement(By.cssSelector("msg-tico[data-tsid='remove_msg_button']"));
        delM.click();
        WebElement yesButton1 = shadowDom.findElement(By.cssSelector("msg-button[data-tsid='confirm-primary']"));
        yesButton1.click();
        Thread.sleep(2000);

        WebElement infoButton = shadowDom.findElement(By.cssSelector("msg-button[data-tsid='chat_info_button']"));
        infoButton.click();
        Thread.sleep(400);
        WebElement leaveChat = shadowDom.findElement(By.cssSelector("msg-tico[data-tsid='leave-chat-btn']"));
        leaveChat.click();
        Thread.sleep(400);
        WebElement yesButton = shadowDom.findElement(By.cssSelector("msg-button[data-tsid='confirm-primary']"));
        yesButton.click();
        Thread.sleep(4000);
        return new UserPage(driver);
    }


}