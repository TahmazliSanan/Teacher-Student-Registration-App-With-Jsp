package org.pronet.app.utils;

public class ParameterUtil {
    public static String getStringValue(String parameter) {
        if (parameter != null) return parameter;
        return "";
    }

    public static long getLongValue(String parameter) {
        if (parameter != null && !parameter.trim().isEmpty()) return Long.parseLong(parameter);
        return 0;
    }
}
