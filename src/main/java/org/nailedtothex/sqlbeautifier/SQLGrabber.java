package org.nailedtothex.sqlbeautifier;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Scanner;

public class SQLGrabber {

    private final InputStream stdin;

    public SQLGrabber(final InputStream stdin) {
        this.stdin = stdin;
    }

    public String grab(final String[] args) throws IOException {
        if (isFilenamePassed(args)) {
            final File file = new File(args[0]);
            return FileUtils.readFileToString(file, Charset.defaultCharset());
        }
        return readStdin();
    }

    private String readStdin() throws IOException {
        final StringBuilder sb = new StringBuilder();
        try (final Scanner scanner = new Scanner(stdin)) {
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append('\n');
            }
        }
        return sb.toString();
    }

    private static boolean isFilenamePassed(final String[] args) {
        return args.length > 0;
    }
}
