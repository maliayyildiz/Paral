package tests;

import org.testng.annotations.Test;
import parallel.Driver;


import java.util.concurrent.TimeUnit;

public class Deneme02
{
    @Test
    public static void test(){
        Driver.getDriver().get("https://urbanicfarm.com");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
}
