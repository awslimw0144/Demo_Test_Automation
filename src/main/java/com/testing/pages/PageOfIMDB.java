package com.testing.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class PageOfIMDB extends PageObject {
    public static Target SEARCHBOX = Target.the("Search Box").locatedBy(".//input[@id='suggestion-search']");
    public static Target MOVIE_CATALOG_DROPDOWN = Target.the("Movie Catalog").locatedBy(".//div[text()='{0}']");

    public static Target NAME_DIRECTOR = Target.the("Name of Director").locatedBy(".//h4[text()='Director:']/following-sibling::a");
}
