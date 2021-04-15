import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class Tests extends BaseTest{

    String username = "";
    String password = "";

    @Before
    public void start() {
        driverInit();
        get();
    }

    @Test
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


    @After
    public void stop(){
        driverDown();
    }
}
