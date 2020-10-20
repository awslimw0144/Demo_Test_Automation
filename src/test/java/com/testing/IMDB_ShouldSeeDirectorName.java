package com.testing;

import com.testing.pojo.DataBase;
import com.testing.questions.CheckForDirector;
import com.testing.tasks.GetFurtherDetails;
import com.testing.tasks.NavigateToWebPage;
import com.testing.tasks.SearchForMovieName;
import com.testing.utils.ResrcUtils;
import com.testing.pojo.ExcelTestable;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.TreeSet;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class IMDB_ShouldSeeDirectorName {
    private TreeSet<String> sTestIDs;
    private final ExcelTestable dataBase = new DataBase(ResrcUtils.getFilePath(IMDB_ShouldSeeDirectorName.class,"TestData.xlsx"));
    private final String worksheetName = "DataSet";
    private final int rowIndex = 0;
    private final String sHeaderTestIDCell = "Context";
    private final String sUserName = "userTaiger";

    @Before
    public void setUpData(){
        this.dataBase.set_Header_Index(this.worksheetName,this.rowIndex);
        this.dataBase.set_TestID_Index(this.worksheetName,this.sHeaderTestIDCell);
        this.sTestIDs = dataBase.getTestIDs(this.worksheetName);
    }

    @Managed(driver="chrome", uniqueSession = true)
    public WebDriver hisBrowser;

    Actor userTaiger = Actor.named(this.sUserName);

    @Before
    public void userCanBrowseTheWeb(){
        userTaiger.can(
                BrowseTheWeb.with(hisBrowser)
        );
    }

    @Test
    public void user_Should_See_The_Director_Name(){
        this.sTestIDs.forEach(sTestID ->{
            String sSearchBox = this.dataBase.getValue(this.worksheetName,sTestID,"Search Box");
            String sDirectorName = this.dataBase.getValue(this.worksheetName,sTestID,"Director");

            givenThat(userTaiger).wasAbleTo(
                    NavigateToWebPage.toPageWithThisURL("https://www.imdb.com")
            );
            when(userTaiger).attemptsTo(
                    SearchForMovieName.with(sSearchBox),
                    GetFurtherDetails.ofDirector()
            );
            then(userTaiger).should(
                    seeThat("The name of the Director is ", CheckForDirector.getName(),equalTo(sDirectorName))
            );
        });
    }
}
