import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class Tests extends BaseTest {

    String username = "";
    String password = "";

    @Before
    public void start() {
        driverInit();
        get();
    }

    @Test

    public void Test() {
        UserPage userPage = new LoginPage(driver).doLogin(username, password);
        MessagePage msgPage = new MsgTest(driver).testMSG();
    }


    @After
    public void stop() {
        driverDown();
    }
}
