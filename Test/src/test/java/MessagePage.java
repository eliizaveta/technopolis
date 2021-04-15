import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MessagePage {

    WebDriver driver;

    private String MSG_LOCATOR = ".//div[@id = 'msg_toolbar_button']";

    MessagePage(WebDriver driver) {
        this.driver = driver;
    }


    public void goToMSG() throws InterruptedException
    {
        Thread.sleep(4);
        driver.findElement(By.xpath(MSG_LOCATOR)).click();
        Thread.sleep(500);
    }

    public WebElement findShadowDomRoot()
    {
        WebElement root = driver.findElement(By.id("msg_layer"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement shadowDom = (WebElement) js.executeScript("return arguments[0].shadowRoot", root);
        return shadowDom;
    }
    public void clickOnElement(WebElement shadowDom, String css) throws InterruptedException
    {
        shadowDom.findElement(By.cssSelector(css)).click();
        Thread.sleep(1000);
    }
    public void createEmptyChat() throws InterruptedException{
        WebElement shadowDom = findShadowDomRoot();
        clickOnElement(shadowDom, "msg-button[data-tsid='open_plus_button']");  //тыкаем на плюсик
        clickOnElement(shadowDom, "msg-menu-item[data-tsid='plus_create_chat']"); //тыкаем создать новый чат
        clickOnElement(shadowDom, "msg-button[data-tsid='finish_create_chat_button']"); //создаем пустой чат
        Thread.sleep(500);
    }

    public void sendSticker() throws InterruptedException{
        WebElement shadowDom = findShadowDomRoot();
        clickOnElement(shadowDom, "msg-button[data-tsid='open_smiles_button']"); //открываем стикеры
        clickOnElement(shadowDom, "msg-assets-sticker[set-id='popular_stickers']"); //тыкаем на первый популярный стикер
        Thread.sleep(500);
    }

    public void deleteMSG() throws InterruptedException{
        WebElement shadowDom = findShadowDomRoot();
        Actions action = new Actions(driver);
        action.moveToElement(shadowDom.findElement(By.cssSelector("msg-message-container"))).build().perform();

        clickOnElement(shadowDom, "msg-button[data-tsid='more_message']"); //тыкаем на действия с сообщением
        clickOnElement(shadowDom, "msg-tico[data-tsid='remove_msg_button']"); //тыкаем удалить сообщение
        clickOnElement(shadowDom, "msg-button[data-tsid='confirm-primary']"); //подтверждаем удаление
        Thread.sleep(500);
    }

    public void deleteChat() throws InterruptedException{
        WebElement shadowDom = findShadowDomRoot();
        clickOnElement(shadowDom, "msg-button[data-tsid='chat_info_button']"); //тыкаем на информацию о чате
        clickOnElement(shadowDom, "msg-tico[data-tsid='leave-chat-btn']"); //тыкаем покинуть чат
        clickOnElement(shadowDom, "msg-button[data-tsid='confirm-primary']"); //подтверждаем
        Thread.sleep(500);
    }


}