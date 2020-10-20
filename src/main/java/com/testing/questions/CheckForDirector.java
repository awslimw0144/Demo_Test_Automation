package com.testing.questions;

import com.testing.pages.PageOfIMDB;
import net.serenitybdd.screenplay.Question;

public class CheckForDirector {
    public static Question<String> getName(){
        return actor -> PageOfIMDB.NAME_DIRECTOR.resolveFor(actor).getText();
    }
}
