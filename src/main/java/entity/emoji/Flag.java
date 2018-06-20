package entity.emoji;

import java.util.Arrays;
import java.util.List;

public class Flag {
    public static final String UA = "\uD83C\uDDFA\uD83C\uDDE6";
    public static final String EU = "\uD83C\uDDEA\uD83C\uDDFA";
    public static final String RU = "\uD83C\uDDF7\uD83C\uDDFA";
    public static final String US = "\uD83C\uDDFA\uD83C\uDDF8";
    public static final String BTC = "\u20BF";

    public static List<String> getFlags() {
        return Arrays.asList(UA, EU, RU, US, BTC);
    }
}
