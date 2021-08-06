package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import parallel.Driver;


import java.util.concurrent.TimeUnit;

public class Deneme02
{
    @BeforeMethod
    public void b(){
        Driver.getDriver().get("https://www.demoqa.com/");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public static void test(){

        System.out.println(Driver.getDriver().getTitle());


    }
}
