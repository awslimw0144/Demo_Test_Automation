package com.testing.actions;

import com.testing.pages.PageOfIMDB;
import com.testing.utils.WaitImplicitly;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class FromListDropDown implements Interaction {

    private String sString;

    public FromListDropDown(String sString){
        this.sString = sString;
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        WaitImplicitly.forElement(PageOfIMDB.MOVIE_CATALOG_DROPDOWN.of(sString),t);
        t.attemptsTo(
                Click.on(PageOfIMDB.MOVIE_CATALOG_DROPDOWN.of(sString))
        );
    }
    public static FromListDropDown select(String sString){
        return Tasks.instrumented(FromListDropDown.class, sString);
    }
}
