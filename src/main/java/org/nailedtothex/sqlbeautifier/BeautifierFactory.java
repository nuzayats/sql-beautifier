package org.nailedtothex.sqlbeautifier;

import org.hibernate.engine.jdbc.internal.BasicFormatterImpl;
import org.hibernate.engine.jdbc.internal.DDLFormatterImpl;

public class BeautifierFactory {

    public Beautifier createDMLBeautifier() {
        return new SQLBeautifier(new BasicFormatterImpl());
    }

    public Beautifier createDDLBeautifier() {
        return new SQLBeautifier(new DDLFormatterImpl());
    }

    public Beautifier createJSONBeautifier() {
        return new JSONBeautifier();
    }
}
