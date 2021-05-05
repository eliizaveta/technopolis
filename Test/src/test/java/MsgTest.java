import org.openqa.selenium.WebDriver;

public class MsgTest {

    WebDriver driver;

    MsgTest(WebDriver driver) {
        this.driver = driver;
    }

    public MessagePage testMSG() {
        MessagePage newPage = new MessagePage(driver);
        newPage.goToMSG();
        newPage.createEmptyChat();
        newPage.sendSticker();
        newPage.checkMSGsent();
        newPage.deleteMSG();
        newPage.checkMSGdeleted();
        newPage.deleteChat();
        return newPage;
    }
}
