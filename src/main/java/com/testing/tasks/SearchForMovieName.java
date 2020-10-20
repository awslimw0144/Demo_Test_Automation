package com.testing.tasks;

import com.testing.actions.FromListDropDown;
import com.testing.actions.TypeIntoTextBox;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.SendKeys;

public class SearchForMovieName implements Task {

    private String sMovieName;

    public SearchForMovieName(String sMovieName){
        this.sMovieName = sMovieName;
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(
                TypeIntoTextBox.withThisString(this.sMovieName),
                FromListDropDown.select(this.sMovieName)
        );
    }

    public static SearchForMovieName with(String sMovieName){
        return Tasks.instrumented(SearchForMovieName.class, sMovieName);
    }
}