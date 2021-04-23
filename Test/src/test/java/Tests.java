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
<<<<<<< HEAD
    public void Test() {
        UserPage userPage = new LoginPage(driver).doLogin(username, password);
        MessagePage msgPage = new MsgTest(driver).testMSG();
    }
=======
   public void Test() throws InterruptedException  {

        boolean flag = true;
        try {
            UserPage userPage = new LoginPage(driver).doLogin(username, password);
            Thread.sleep(500);
            MessagePage msgPage = new MsgTest(driver).testMSG();
            Thread.sleep(500);
        }catch (Exception ex)
        {
            flag = false;
        }
        finally {
            if(flag) System.out.println("Test completed successfully");
            else System.out.println("test completed with error");
        }
   }
>>>>>>> 75a53b6062640e7266a3bdb27a706f955eb7b986


    @After
    public void stop() {
        driverDown();
    }
}
