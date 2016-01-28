package org.nailedtothex.sqlbeautifier;

import org.apache.commons.cli.ParseException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MyCommandLineParserTest {

    private MyCommandLineParser sut = new MyCommandLineParser();

    @Test
    public void shouldUseStdinAndDMLFormatterForEmptyArgs() throws Exception {
        final MyCommandLine result = sut.parse(new String[0]);

        assertThat(result.getSourcePath(), is(nullValue()));
        assertThat(result.getMode(), is(MyCommandLineMode.DML));
        assertThat(result.isUseStdin(), is(true));
    }

    @Test
    public void shouldUseSourcePathForFilenameSupplied() throws Exception {
        final String input = "foo.sql";

        final MyCommandLine result = sut.parse(new String[]{input});

        assertThat(result.getSourcePath(), is(input));
        assertThat(result.getMode(), is(MyCommandLineMode.DML));
        assertThat(result.isUseStdin(), is(false));
    }

    @Test
    public void shouldUseDDLFormatterForOptionSupplied() throws Exception {
        final MyCommandLine result = sut.parse(new String[]{"-d"});

        assertThat(result.getSourcePath(), is(nullValue()));
        assertThat(result.getMode(), is(MyCommandLineMode.DDL));
        assertThat(result.isUseStdin(), is(true));
    }

    @Test
    public void shouldUseJSONFormatterForOptionSupplied() throws Exception {
        final MyCommandLine result = sut.parse(new String[]{"-j"});

        assertThat(result.getSourcePath(), is(nullValue()));
        assertThat(result.getMode(), is(MyCommandLineMode.JSON));
        assertThat(result.isUseStdin(), is(true));
    }

    @Test(expected = ParseException.class)
    public void shouldThrowExceptionForUnsupportedOptionSupplied() throws Exception {
        sut.parse(new String[]{"-a"});
    }

    @Test(expected = ParseException.class)
    public void shouldThrowExceptionForMultipleArgumentsSupplied() throws Exception {
        sut.parse(new String[]{"foo.sql", "bar.sql"});
    }
}

