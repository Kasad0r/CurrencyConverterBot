package entity;

import entity.emoji.Conversion;
import entity.enums.Position;
import entity.enums.TriggeType;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

final public class TempUserUnit implements Comparable<TempUserUnit> {
    private long userId;
    private BigDecimal value;
    private String currencyToConvert;
    private Position position = Position.GENERALMENU;
    private TriggeType triggerType = TriggeType.NONE;

    public TempUserUnit(long userId) {
        this.userId = userId;
    }

    public TempUserUnit() {
    }

    public TempUserUnit(long userId, BigDecimal value,String currencyToConvert, Position position, TriggeType triggeType) {
        this.userId = userId;
        this.value = value;
        this.currencyToConvert = currencyToConvert;
        this.position = position;
        this.triggerType = triggeType;
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

    public String getCurrencyToConvert() {
        return currencyToConvert;
    }

    public void setCurrencyToConvert(String currencyToConvert) {
        this.currencyToConvert = currencyToConvert;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public TriggeType getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(TriggeType toDo) {
        this.triggerType = toDo;
    }

    @Override
    public String toString() {
        return "TempUserUnit{" +
                "userId=" + userId +
                ", value=" + value +
                ", currencyToConvert=" + currencyToConvert +
                ", position=" + position +
                ", TruggerType=" + triggerType +
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
                Objects.equals(triggerType, that.triggerType);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, value, currencyToConvert, position, triggerType);
    }

    @Override
    public int compareTo(TempUserUnit o) {
        return Long.compare(this.userId, o.userId);
    }
}
