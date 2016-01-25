package org.nailedtothex.sqlbeautifier;

import org.hibernate.engine.jdbc.internal.BasicFormatterImpl;
import org.hibernate.engine.jdbc.internal.DDLFormatterImpl;

public class BeautifierFactory {

    public Beautifier createDMLBeautifier() {
        return new Beautifier(new BasicFormatterImpl());
    }

    public Beautifier createDDLBeautifier() {
        return new Beautifier(new DDLFormatterImpl());
    }
}
