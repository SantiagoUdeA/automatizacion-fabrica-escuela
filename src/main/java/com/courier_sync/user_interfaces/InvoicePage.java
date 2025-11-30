package com.courier_sync.user_interfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class InvoicePage extends PageObject {

    public static final Target EMISSION_DATE_INPUT = Target.the("Emission Date Input")
            .locatedBy("(//input[@type='date'])[1]");

    public static final Target EXPIRATION_DATE_INPUT = Target.the("Expiration Date Input")
            .locatedBy("(//input[@type='date'])[2]");

    public static final Target SAVE_CHANGES_BUTTON = Target.the("Save Changes Button")
            .locatedBy("//*[@id=\"root\"]/div[2]/main/form/div[3]/button[2]");

    public static final Target SUCCESS_MESSAGE = Target.the("Success Message")
            .locatedBy("//*[@id=\"root\"]/div[1]/ol/li/div/div[2]");
}

