package entity;

import entity.enums.Position;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

final public class TempUserUnit implements Comparable<TempUserUnit> {
    private long userId;
    private BigDecimal value;
    private List<CurrencyEntity> currencyToConvert;
    private Position position = Position.GENERALMENU;
    private Trigger toDo;

    public TempUserUnit(long userId) {
        this.userId = userId;
    }

    public TempUserUnit() {
    }

    public TempUserUnit(long userId, BigDecimal value, List<CurrencyEntity> currencyToConvert, Position position, Trigger toDo) {
        this.userId = userId;
        this.value = value;
        this.currencyToConvert = currencyToConvert;
        this.position = position;
        this.toDo = toDo;
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

    public void setCurrencyToConvert(List<CurrencyEntity> currencyToConvert) {
        this.currencyToConvert = currencyToConvert;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Trigger getToDo() {
        return toDo;
    }

    public void setToDo(Trigger toDo) {
        this.toDo = toDo;
    }

    @Override
    public String toString() {
        return "TempUserUnit{" +
                "userId=" + userId +
                ", value=" + value +
                ", currencyToConvert=" + currencyToConvert +
                ", position=" + position +
                ", toDo=" + toDo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TempUserUnit that = (TempUserUnit) o;
        return userId == that.userId &&
                Objects.equals(value, that.value) &&
                Objects.equals(currencyToConvert, that.currencyToConvert) &&
                position == that.position &&
                Objects.equals(toDo, that.toDo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, value, currencyToConvert, position, toDo);
    }

    @Override
    public int compareTo(TempUserUnit o) {
        return Long.compare(this.userId, o.userId);
    }
}
