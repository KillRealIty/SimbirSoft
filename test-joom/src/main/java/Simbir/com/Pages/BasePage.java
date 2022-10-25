package Simbir.com.Pages;

import Simbir.com.Mangers.ManagerDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(ManagerDriver.getDriver(),this);
    }
}
