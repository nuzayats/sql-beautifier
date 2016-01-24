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
            new HelpFormatter().printHelp("java -jar sql-beautifulier.jar [OPTION]... [FILE]...", parser.getOptions());
            return;
        }

        final Beautifier beautifulier = createBeautifulier(commandLine);
        final String sql = grabSQL(commandLine);
        System.out.println(beautifulier.beautify(sql));
    }

    private static String grabSQL(final MyCommandLine commandLine) throws IOException {
        if (commandLine.isUseStdin()) {
            return IOUtils.toString(System.in, Charset.defaultCharset());
        }
        return FileUtils.readFileToString(new File(commandLine.getSourcePath()), Charset.defaultCharset());
    }

    private static Beautifier createBeautifulier(final MyCommandLine commandLine) {
        final BeautifierFactory factory = new BeautifierFactory();
        if (commandLine.isUseDDLFormatter()) {
            return factory.createDDLBeautifulier();
        }
        return factory.createDMLBeautifulier();
    }
}
