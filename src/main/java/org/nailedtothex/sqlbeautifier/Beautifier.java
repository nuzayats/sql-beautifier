package org.nailedtothex.sqlbeautifier;

import org.hibernate.engine.jdbc.internal.Formatter;

public class Beautifier {

    private final Formatter formatter;

    public Beautifier(final Formatter formatter) {
        this.formatter = formatter;
    }

    public String beautify(final String sql) {
        return formatter.format(sql);
    }
}
