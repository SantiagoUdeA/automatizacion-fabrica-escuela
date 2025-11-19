package com.buggy_cars_rating.user_interfaces;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl("https://www.google.com/")
public class GooglePage extends PageObject {

    public static final Target INPUT_TEXT = Target.the("Input text search")
            .located(By.name("q"));
    //.locatedBy("//*[@name=\"q\"]");}

    public static final Target UDEALINK = Target.the("U de A link")
            .located(By.xpath("//*[@href=\"https://www.udea.edu.co/\"]"));
}
