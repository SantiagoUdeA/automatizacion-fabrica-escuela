package com.courier_sync.user_interfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class LoginPage extends PageObject {

    public static final Target EMAIL_INPUT = Target.the("Email input field")
            .locatedBy("//*[@id=\":r2:-form-item\"]/input");

    public static final Target PASSWORD_INPUT = Target.the("Password input field")
            .locatedBy("//*[@id=\":r3:-form-item\"]/input");

    public static final Target SUBMIT_BUTTON = Target.the("Submit button")
            .locatedBy("//*[@id=\"root\"]/div[2]/div/div[2]/form/button");

    public static final Target ERROR_MESSAGE = Target.the("Error message")
            .locatedBy("//*[@id=\"root\"]/div[1]/ol/li/div/div[2]");

}
