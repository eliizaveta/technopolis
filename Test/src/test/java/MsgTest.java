import org.openqa.selenium.WebDriver;

public class MsgTest {

    WebDriver driver;

    MsgTest(WebDriver driver) {
        this.driver = driver;
    }

    public MessagePage testMSG() throws InterruptedException{
        MessagePage newPage = new MessagePage(driver);
        newPage.goToMSG();
        newPage.createEmptyChat();
        newPage.sendSticker();
        newPage.deleteMSG();
        newPage.deleteChat();
        return newPage;
    }
}
