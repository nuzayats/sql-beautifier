package org.nailedtothex.sqlbeautifier;

import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.ParseException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) throws IOException {
        final MyCommandLineParser parser = new MyCommandLineParser();

        final MyCommandLine commandLine;
        try {
            commandLine = parser.parse(args);
        } catch (final ParseException e) {
            new HelpFormatter().printHelp("java -jar sql-beautifier.jar [OPTION] [FILE]", parser.getOptions());
            return;
        }

        final Beautifier beautifier = createBeautifier(commandLine);
        final String sql = grabSQL(commandLine);
        System.out.println(beautifier.beautify(sql));
    }

    private static String grabSQL(final MyCommandLine commandLine) throws IOException {
        if (commandLine.isUseStdin()) {
            return IOUtils.toString(System.in, Charset.defaultCharset());
        }
        return FileUtils.readFileToString(new File(commandLine.getSourcePath()), Charset.defaultCharset());
    }

    private static Beautifier createBeautifier(final MyCommandLine commandLine) {
        final BeautifierFactory factory = new BeautifierFactory();
        switch (commandLine.getMode()) {
            case DML:
                return factory.createDMLBeautifier();
            case DDL:
                return factory.createDDLBeautifier();
            case JSON:
                return factory.createJSONBeautifier();
        }
        throw new IllegalArgumentException(String.valueOf(commandLine.getMode()));
    }
}
