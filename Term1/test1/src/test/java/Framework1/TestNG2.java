package Framework1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(Framework1.Listeners.class)
public class TestNG2 {

    @AfterTest(enabled = false, groups = "smoke")
    public void demo4() {
        System.out.println("AfterTest2.1");
    }

    @AfterSuite(groups = "smoke", timeOut = 5000)
    public void demo7() {
        System.out.println("AfterSuite2.1");
    }

    @BeforeTest(groups = "regression")
    public void demo5() {
        System.out.println("BeforeTestTest2.");
    }

    @Test(groups = "smoke")
    public void demo6() {
        System.out.println("Shoud be second, but its first because off dependency.");
    }

    @Test(groups = "regression", dependsOnMethods = {"demo6"})
    public void Ademo11() {
        System.out.println("Should be First Depends of Test 2.");
    }

    @BeforeMethod(groups = "smoke")
    public void demo8() {
        System.out.println("BeforeMethod.");
    }

    @AfterClass(groups = "smoke")
    public void demo9() {
        System.out.println("AfterClass.");
    }

    @AfterMethod(groups = "smoke")
    public void demo10() {
        System.out.println("AfterMethod.");
    }

    @Test(dataProvider="getData")
    public void usernamesAndPasswords(String username, String password) {
        System.out.println("This is the test with Usernames and Paasswords");
        System.out.println(username + "" + password);
    }

    @DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[3][2];
        data[0][0] = "FirstUsername";
        data[0][1] = "FirstPassword";

        data[1][0] = "SecondUsername";
        data[1][1] = "SecondPassword";

        data[2][0] = "ThirdUsername";
        data[2][1] = "ThirdPassword";
        return data;
    }
}
