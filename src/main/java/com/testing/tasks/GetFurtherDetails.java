package com.testing.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class GetFurtherDetails implements Task {

    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(

        );
    }
    public static GetFurtherDetails ofDirector(){
        return Tasks.instrumented(GetFurtherDetails.class);
    }
}
