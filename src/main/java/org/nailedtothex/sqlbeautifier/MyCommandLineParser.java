package org.nailedtothex.sqlbeautifier;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import java.util.List;

public class MyCommandLineParser {

    private final Options options;

    public MyCommandLineParser() {
        options = new Options();
        options.addOption("d", "use-ddl-formatter", false, "Use DDL formatter instead of basic formatter");
    }

    public Options getOptions() {
        return options;
    }

    public MyCommandLine parse(final String[] args) throws ParseException {
        final CommandLine commandLine = new DefaultParser().parse(options, args);
        final List<String> argList = commandLine.getArgList();

        final boolean useStdin = argList.isEmpty();
        final boolean useDDLFormatter = commandLine.hasOption("d");

        if (useStdin) {
            return new MyCommandLine(useDDLFormatter);
        }

        if (argList.size() > 1) {
            throw new ParseException("Multiple file input is not supported");
        }

        return new MyCommandLine(argList.get(0), useDDLFormatter);
    }
}
