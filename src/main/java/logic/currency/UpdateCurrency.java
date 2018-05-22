package logic.currency;

import entity.CurrencyEntity;

import java.util.*;

public class UpdateCurrency extends TimerTask {
    private static List<CurrencyEntity> currencyEntities = new ArrayList<CurrencyEntity>();

    public UpdateCurrency(boolean turnOnTimer) {
        start();
    }

    public UpdateCurrency() {

    }

    public static List<CurrencyEntity> getCurrencyEntities() {
        return currencyEntities;
    }

    public void start() {
        Timer time = new Timer();
        UpdateCurrency st = new UpdateCurrency();
        time.schedule(st, 0, 10000);
    }

    public void run() {
        CurrencyData currencyData = new CurrencyData();
        currencyEntities = currencyData.parseJson();
        System.out.println(currencyEntities);
    }

    public static Optional<CurrencyEntity> searchCurrencyByBaseCCY(String name) {
        return currencyEntities.stream()
                .filter(p -> p.getBaseCCY().equals(name)).findAny();
    }

    public static Optional<CurrencyEntity> searchCurrencyByCCY(String name) {
        return currencyEntities.stream()
                .filter(p -> p.getCcy().equals(name)).findAny();
    }
}
