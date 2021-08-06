package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import parallel.Driver;


import java.util.concurrent.TimeUnit;

public class Deneme01
{
    @BeforeMethod
    public void a(){
        Driver.getDriver().get("https://www.demoqa.com/");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test(groups = {"smoke"})
    public static void test(){

        System.out.println(Driver.getDriver().getTitle());

    }

    @Test
    public static void test01(){

        System.out.println(Driver.getDriver().getTitle()+"2");

    }
}
