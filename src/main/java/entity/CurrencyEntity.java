package entity;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.Objects;

public class CurrencyEntity implements Comparable {
    String baseCCY;
    String ccy;
    double buy;
    double sale;

    public CurrencyEntity() {
    }

    public CurrencyEntity(String baseCCY, String ccy, double buy, double sale) {
        this.baseCCY = baseCCY;
        this.ccy = ccy;
        this.buy = buy;
        this.sale = sale;
    }

    @Override
    public int compareTo(Object o) {
        return this.baseCCY.compareTo(((CurrencyEntity) o).baseCCY);
    }

    public CurrencyEntity(String baseCCY) {
        this.baseCCY = baseCCY;
    }

    @Override
    public String toString() {
        return "CurrencyEntity{" +
                "baseCCY='" + baseCCY + '\'' +
                ", ccy='" + ccy + '\'' +
                ", buy=" + buy +
                ", sale=" + sale +

                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyEntity that = (CurrencyEntity) o;
        return Double.compare(that.buy, buy) == 0 &&
                Double.compare(that.sale, sale) == 0 &&
                Objects.equals(baseCCY, that.baseCCY) &&
                Objects.equals(ccy, that.ccy);
    }

    @Override
    public int hashCode() {

        return Objects.hash(baseCCY, ccy, buy, sale);
    }

    public String getBaseCCY() {
        return baseCCY;
    }

    public void setBaseCCY(String baseCCY) {
        this.baseCCY = baseCCY;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public double getBuy() {
        return buy;
    }

    public void setBuy(double buy) {
        this.buy = buy;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }
}
