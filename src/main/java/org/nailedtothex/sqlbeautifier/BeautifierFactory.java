package org.nailedtothex.sqlbeautifier;

import org.hibernate.engine.jdbc.internal.BasicFormatterImpl;
import org.hibernate.engine.jdbc.internal.DDLFormatterImpl;

public class BeautifierFactory {

    public Beautifier createDMLBeautifulier() {
        return new Beautifier(new BasicFormatterImpl());
    }

    public Beautifier createDDLBeautifulier() {
        return new Beautifier(new DDLFormatterImpl());
    }
}
