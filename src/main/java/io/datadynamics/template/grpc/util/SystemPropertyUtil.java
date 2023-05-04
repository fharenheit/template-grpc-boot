package io.datadynamics.template.grpc.util;

public class SystemPropertyUtil {

    public static String get(String key) {
        return get(key, null);
    }

    public static String get(final String key, String def) {
        String value = System.getProperty(key);
        if (value == null) {
            return def;
        }

        return value;
    }
}
