package com.testing.utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class WaitImplicitly {
    public static void forElement(Target target, Actor t){
        new WebDriverWait(getDriver(), 20)
                .withTimeout(Duration.ofSeconds(1))
                .pollingEvery(Duration.ofMillis(200))
                .until(ExpectedConditions.visibilityOf(target.resolveFor(t)));
    }
}
