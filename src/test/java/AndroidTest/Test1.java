package AndroidTest;

import com.Automation.BaseTest;
import com.PageObjects.Homepage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test1 extends BaseTest {
    private Homepage page;


    @BeforeClass(alwaysRun = true)
    public void setup(){
        page=new Homepage(driverFactory);

    }
    @Test
    public void helloworld(){
        System.out.println("hello here");
        page.clickonpreference();
        if(driverFactory.isAndroidPlatform()){
            System.out.println("i am android");
        }
        else{
            System.out.println("I Am iOS");
            //You can write specific ios code here if required


        }
//Comments

        //if any driver specific method is required then you can use following code

  //      ((IOSDriver)driverFactory.getdriver()).performTouchID();

       // ((AndroidDriver)driverFactory.getdriver()).toggleAirplaneMode();
    }

    @AfterClass
    public void teardown(){
        super.tearDown();
    }
}
