package util;

import java.util.Properties;

public class Secret {
    static public void setPass(Properties dbproperties) {
        dbproperties.setProperty("user", "postgres");
        dbproperties.setProperty("password","inspass" );
    }
}
