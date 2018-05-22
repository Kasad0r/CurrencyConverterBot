package logic.currency;

import entity.CurrencyEntity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.NoSuchElementException;
import java.util.Optional;

public class CurrencyController {
    static {

    }


    public static void main(String[] args) {
        UpdateCurrency updateCurrency = new UpdateCurrency(true);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(UpdateCurrency.getCurrencyEntities());
        System.out.println(new CurrencyController().calculateAtTheRate("USD", "EUR", 28));
    }

    /**
     * Создать возвр тип. Переделать метод под ретерн. Ибо при срабатівании ифа обязательно должен быть
     * ретерн
     *
     * @param fromCurrency
     * @param toCurrency
     * @param value
     */

    public CurrencyEntity calculateAtTheRate(String fromCurrency, String toCurrency, double value) {
        System.out.println(value);
        System.out.println(fromCurrency);
        System.out.println(toCurrency);
        System.out.println("====================");
        for (CurrencyEntity currencyEntity : UpdateCurrency.getCurrencyEntities()
                ) {
            System.out.println("WORK!");
            if (currencyEntity.getBaseCCY().equals(fromCurrency)
                    && currencyEntity.getCcy().equals(toCurrency)) {

                CurrencyEntity result = new CurrencyEntity();
                result.
                        setBuy(new BigDecimal(value)
                                .multiply(new BigDecimal(currencyEntity.getBuy()))
                                .doubleValue());
                result.
                        setSale(new BigDecimal(value)
                                .multiply(new BigDecimal(currencyEntity.getSale()))
                                .doubleValue());
                return result;
            } else if (currencyEntity.getBaseCCY().equals(toCurrency)
                    && currencyEntity.getCcy().equals(fromCurrency)) {
                System.out.println("+__+");

                CurrencyEntity result = new CurrencyEntity();

                result.setBuy(new BigDecimal(value).multiply(new BigDecimal(1).
                        divide(new BigDecimal(currencyEntity.getBuy()), RoundingMode.HALF_UP))
                        .doubleValue());

                result.setSale(new BigDecimal(value).multiply(new BigDecimal(1).
                        divide(new BigDecimal(currencyEntity.getSale()), RoundingMode.HALF_UP))
                        .doubleValue());

                return result;
            }
        }
        for (CurrencyEntity currencyEntity : UpdateCurrency.getCurrencyEntities()
                ) {
            if (currencyEntity.getCcy().equals(fromCurrency)) {
                calculateAtTheRate(currencyEntity.getBaseCCY(), toCurrency,
                        BigDecimal.ONE
                                .divide(new BigDecimal(currencyEntity.getBuy()), RoundingMode.HALF_UP)
                                .multiply(new BigDecimal(value))
                                .doubleValue());
            } else if (currencyEntity.getBaseCCY().equals(fromCurrency)) {
                calculateAtTheRate(currencyEntity.getCcy(), toCurrency,
                        new BigDecimal(value)
                                .multiply(new BigDecimal(currencyEntity.getBuy()))
                                .doubleValue());
            } else if (currencyEntity.getCcy().equals(toCurrency)) {
                calculateAtTheRate(fromCurrency, currencyEntity.getCcy(),
                        BigDecimal.ONE
                                .divide(new BigDecimal(currencyEntity.getBuy()), RoundingMode.HALF_UP)
                                .multiply(new BigDecimal(value))
                                .doubleValue());
            } else if (currencyEntity.getBaseCCY().equals(toCurrency)) {
                calculateAtTheRate(fromCurrency, currencyEntity.getBaseCCY(),
                        new BigDecimal(value)
                                .multiply(new BigDecimal(currencyEntity.getBuy()))
                                .doubleValue());
            }
        }
        return null;
    }

    public CurrencyEntity calculate(String from, String to, BigDecimal value) {
        Optional<CurrencyEntity> fromOpt = UpdateCurrency.searchCurrencyByBaseCCY(from);
        Optional<CurrencyEntity> toOpt = UpdateCurrency.searchCurrencyByBaseCCY(to);
        fromOpt = checkOptionValue(from, fromOpt);
        toOpt = checkOptionValue(to, toOpt);
        if (fromOpt.get().equals(toOpt.get())) {
            return new CurrencyEntity(from, to, value.doubleValue(), value.doubleValue());
        }
        return null;
    }

    private Optional<CurrencyEntity> checkOptionValue(String currency, Optional<CurrencyEntity> toOpt) {
        if (!toOpt.isPresent()) {
            toOpt = UpdateCurrency.searchCurrencyByCCY(currency);
            if (!toOpt.isPresent()) {
                throw new NoSuchElementException("Wrong currency name: " + currency);
            } else {
                toOpt.get().setBaseCCY(null);
            }
        } else {
            toOpt.get().setCcy(null);
        }
        return toOpt;
    }

}