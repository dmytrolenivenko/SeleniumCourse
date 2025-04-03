package Framework1;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestNG1 {

    @BeforeClass(groups = "regression")
    public void demo0() {
        String hello = "BeforeClass";
        String hello2 = "Hello";
        System.out.println(hello + "" + hello2);
    }
    @BeforeTest(groups = "regression")
    public void demo1() {
        String hello = "BeforeTest";
        String hello2 = "Hello";
        System.out.println(hello + "" + hello2);
    }

    @BeforeSuite(groups = "regression")
    public void demo2() {
        String hello = "BeforeSuite2";
        String hello2 = "Hello";
        System.out.println(hello + "" + hello2);
    }

    @Test(groups = "regression")
    public void demo3() {
        String hello = "Test3";
        String hello2 = "Hello";
        System.out.println(hello + "" + hello2);
    }

}
