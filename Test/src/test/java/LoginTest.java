import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class LoginTest extends BaseTest{

   // WebDriver driver;
    String username = "";
    String password = "";

   // String msg = "darova";


    @Before
    public void start() {
        driverInit();
        get();
    }

    @Test
   public void testGoogleSearch() throws InterruptedException  {
        UserPage userPage = new LoginPage(driver).doLogin(username, password);
        Thread.sleep(300);
        UserPage userPage1 = new NewPage(driver).goToMSG();
        Thread.sleep(300);
        UserPage userPage2 = new NewPage(driver).clickAddTextChatButton();
        Thread.sleep(400);
        UserPage userPage3 = new NewPage(driver).sendMSG();
        UserPage userPage4 = new NewPage(driver).deleteChat();
    }

    @After
    public void stop(){
        driverDown();
    }
}
