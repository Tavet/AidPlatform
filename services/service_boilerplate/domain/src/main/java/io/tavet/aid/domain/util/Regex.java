package io.tavet.aid.domain.util;

public final class Regex {
    public static final String LATITUDE_REGEX = "^[-+]?([1-8]?\\d(\\.\\d+)?|90(\\.0+)?)$";
    public static final String LONGITUDE_REGEX = "^[-+]?(180(\\.0+)?|((1[0-7]\\d)|([1-9]?\\d))(\\.\\d+)?)$";
}
