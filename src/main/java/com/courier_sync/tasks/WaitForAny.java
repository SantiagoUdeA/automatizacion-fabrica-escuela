package com.courier_sync.tasks;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;

/*
 * Tarea que espera hasta que cualquiera de los elementos especificados sea visible en la página.
 */
public class WaitForAny implements Task {

    private final Target[] targets;

    public WaitForAny(Target... targets) {
        this.targets = targets;
    }

    public static WaitForAny of(Target... targets) {
        return new WaitForAny(targets);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        long timeout = 10000; // 10s
        long start = System.currentTimeMillis();

        boolean found = false;

        while (!found && (System.currentTimeMillis() - start) < timeout) {
            for (Target target : targets) {
                if (target.resolveFor(actor).isVisible()) {
                    found = true;
                    break;
                }
            }
            Serenity.takeScreenshot();
            try { Thread.sleep(250); } catch (Exception ignored) {}
        }

        if (!found) {
            throw new AssertionError("No target appeared within time");
        }
    }
}
