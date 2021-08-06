package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import parallel.Driver;


import java.util.concurrent.TimeUnit;

public class Deneme02
{

    @Test(groups = {"smoke"})
    public static void test(){
        Driver.getDriver().get("https://www.demoqa.com/");
        System.out.println(Driver.getDriver().getTitle());

    }
}
