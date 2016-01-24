package org.nailedtothex.sqlbeautifulier;

public class MyCommandLine {

    private final boolean useStdin;
    private final boolean useDDLFormatter;
    private final String sourcePath;

    public MyCommandLine(final boolean useDDLFormatter) {
        this(true, null, useDDLFormatter);
    }

    public MyCommandLine(final String sourcePath, final boolean useDDLFormatter) {
        this(false, sourcePath, useDDLFormatter);
    }

    private MyCommandLine(final boolean useStdin, final String sourcePath, final boolean useDDLFormatter) {
        this.useStdin = useStdin;
        this.sourcePath = sourcePath;
        this.useDDLFormatter = useDDLFormatter;
    }

    public boolean isUseStdin() {
        return useStdin;
    }

    public boolean isUseDDLFormatter() {
        return useDDLFormatter;
    }

    public String getSourcePath() {
        return sourcePath;
    }
}
