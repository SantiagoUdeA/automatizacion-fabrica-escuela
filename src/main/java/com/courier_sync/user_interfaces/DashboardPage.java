package com.courier_sync.user_interfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;


public class DashboardPage extends PageObject {

    public static final Target DASHBOARD_MAIN = Target.the("Dashboard Title")
            .locatedBy("//*[@id=\"root\"]/div[2]/main");

    public static final Target EDIT_INVOICE = Target.the("Edit invoide")
            .locatedBy("//*[@id=\"root\"]/div[2]/main/div[2]/div[2]/div/table/tbody/tr[4]/td[6]/div/button[2]");
}
