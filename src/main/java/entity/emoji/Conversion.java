package entity.emoji;

import java.util.Arrays;
import java.util.List;

public class  Conversion {
    public static final String UAtoUSA = Flag.UA + "-" + Flag.US;
    public static final String USAtoUA = Flag.US + "-" + Flag.UA;
    public static final String UAtoEU = Flag.UA + "-" + Flag.EU;
    public static final String EUtoUA = Flag.EU + "-" + Flag.UA;
    public static final String UAtoRU = Flag.UA + "-" + Flag.RU;
    public static final String RUtoUA = Flag.RU + "-" + Flag.UA;
    public static final String BTCtoUSA = Flag.BTC + "-" + Flag.US;
    public static final String USAtoTBC = Flag.US + "-" + Flag.BTC;

    public static List<String> getConversionList() {
        return Arrays.asList(UAtoUSA, USAtoUA, UAtoEU, EUtoUA, UAtoRU, RUtoUA, BTCtoUSA, USAtoTBC);
    }

}
