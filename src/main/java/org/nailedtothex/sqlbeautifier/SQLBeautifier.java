package org.nailedtothex.sqlbeautifier;

import org.hibernate.engine.jdbc.internal.Formatter;

public class SQLBeautifier implements Beautifier {

    private final Formatter formatter;

    public SQLBeautifier(final Formatter formatter) {
        this.formatter = formatter;
    }

    public String beautify(final String sql) {
        return formatter.format(sql);
    }
}
