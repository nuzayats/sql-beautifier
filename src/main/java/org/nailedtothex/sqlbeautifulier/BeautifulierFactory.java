package org.nailedtothex.sqlbeautifulier;

import org.hibernate.engine.jdbc.internal.BasicFormatterImpl;
import org.hibernate.engine.jdbc.internal.DDLFormatterImpl;

public class BeautifulierFactory {

    public Beautifulier createDMLBeautifulier() {
        return new Beautifulier(new BasicFormatterImpl());
    }

    public Beautifulier createDDLBeautifulier() {
        return new Beautifulier(new DDLFormatterImpl());
    }
}
