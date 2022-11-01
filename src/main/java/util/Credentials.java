package util;

import java.util.Properties;

public abstract class Credentials {
    static public void setPass(Properties dbproperties) {
        dbproperties.setProperty("user", "local_r0123456");
        dbproperties.setProperty("password","dfsgsdgsgshfhfs" );
    }
}

