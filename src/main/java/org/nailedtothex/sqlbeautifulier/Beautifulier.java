package org.nailedtothex.sqlbeautifulier;

import org.hibernate.engine.jdbc.internal.Formatter;

public class Beautifulier {

    private final Formatter formatter;

    public Beautifulier(final Formatter formatter) {
        this.formatter = formatter;
    }

    public String beautifulize(final String sql) {
        return formatter.format(sql);
    }
}
