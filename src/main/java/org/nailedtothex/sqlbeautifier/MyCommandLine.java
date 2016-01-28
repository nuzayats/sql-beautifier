package org.nailedtothex.sqlbeautifier;

public class MyCommandLine {

    private final boolean useStdin;
    private final String sourcePath;
    private final MyCommandLineMode mode;

    public MyCommandLine(final MyCommandLineMode mode) {
        this(true, null, mode);
    }

    public MyCommandLine(final String sourcePath, final MyCommandLineMode mode) {
        this(false, sourcePath, mode);
    }

    private MyCommandLine(final boolean useStdin, final String sourcePath, final MyCommandLineMode mode) {
        this.useStdin = useStdin;
        this.sourcePath = sourcePath;
        this.mode = mode;
    }

    public boolean isUseStdin() {
        return useStdin;
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public MyCommandLineMode getMode() {
        return mode;
    }
}
