package com.testing.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateToWebPage implements Task {

    private String sURL;

    public NavigateToWebPage(String sURL){
        this.sURL = sURL;
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(
                Open.url(this.sURL)
        );
    }

    public static NavigateToWebPage toPageWithThisURL(String sURL){
        return Tasks.instrumented(NavigateToWebPage.class, sURL);
    }
}