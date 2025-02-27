package testng;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_12_DependOnTest {

    @Test
    public void TC_01_Creat_Product() {
        System.out.println("TC_01_Creat_Product");
        Assert.assertFalse(true);
    }

    @Test(dependsOnMethods = "TC_01_Creat_Product" )
    public void TC_02_View_Product() {
        System.out.println("TC_02_View_Product");
    }

    @Test
    public void TC_03_Edit_Product() {
        System.out.println("TC_03_Edit_Product");
    }

    @Test
    public void TC_04_Delete_Product() {
        System.out.println("TC_04_Delete_Product");
    }
}
