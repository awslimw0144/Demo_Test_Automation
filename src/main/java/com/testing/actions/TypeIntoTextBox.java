package com.testing.actions;

import com.testing.pages.PageOfIMDB;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;

public class TypeIntoTextBox implements Interaction {

    private String sString;

    public TypeIntoTextBox(String sString){
        this.sString = sString;
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(
                Enter.theValue(this.sString)
                        .into(PageOfIMDB.SEARCHBOX)
        );
    }

    public static TypeIntoTextBox withThisString(String sString){
        return Tasks.instrumented(TypeIntoTextBox.class, sString);
    }
}