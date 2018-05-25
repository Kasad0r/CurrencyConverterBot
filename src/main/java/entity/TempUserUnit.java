package entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

final public class TempUserUnit implements Comparable<TempUserUnit> {
    private long userId;
    private BigDecimal value;
    private List<CurrencyEntity> currencyToConvert;
    private Position position = Position.MAINMENU;

    public TempUserUnit(long userId, BigDecimal value, List<CurrencyEntity> currencyToConvert, Position position) {
        this.userId = userId;
        this.value = value;
        this.currencyToConvert = currencyToConvert;
        this.position = position;
    }

    public TempUserUnit(long userId) {
        this.userId = userId;
    }

    public TempUserUnit() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public List<CurrencyEntity> getCurrencyToConvert() {
        return currencyToConvert;
    }

    public void setCurrencyToConvert(CurrencyEntity from, CurrencyEntity to) {
        this.currencyToConvert = new ArrayList<>();
        this.currencyToConvert.add(0, from);
        this.currencyToConvert.add(1, to);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "TempUserUnit{" +
                "userId=" + userId +
                ", value=" + value +
                ", currencyToConvert=" + currencyToConvert +
                ", position=" + position +
                '}';
    }


    @Override
    public int compareTo(TempUserUnit o) {
        return Long.compare(this.userId, o.userId);
    }
}
