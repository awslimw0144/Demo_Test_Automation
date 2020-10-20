package com.taiger.suite;

import com.testing.IMDB_ShouldSeeDirectorName;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(value={
        IMDB_ShouldSeeDirectorName.class
})

public class TestSuite_Positive {}