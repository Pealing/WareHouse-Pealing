package com.entity;

import javax.persistence.*;

/**
 * Created by Pealing on 2017/9/4.
 */
@Entity
@Table(name = "discount", schema = "warehouse", catalog = "")
public class DiscountEntity {
    private Double totalFirst;
    private Double totalSecond;
    private Double totalThird;
    private Double discountFirst;
    private Double discountSecond;
    private Double discountThird;
    private int id;

    @Basic
    @Column(name = "TotalFirst", nullable = true, precision = 0)
    public Double getTotalFirst () {
        return totalFirst;
    }

    public void setTotalFirst ( Double totalFirst ) {
        this.totalFirst = totalFirst;
    }

    @Basic
    @Column(name = "TotalSecond", nullable = true, precision = 0)
    public Double getTotalSecond () {
        return totalSecond;
    }

    public void setTotalSecond ( Double totalSecond ) {
        this.totalSecond = totalSecond;
    }

    @Basic
    @Column(name = "TotalThird", nullable = true, precision = 0)
    public Double getTotalThird () {
        return totalThird;
    }

    public void setTotalThird ( Double totalThird ) {
        this.totalThird = totalThird;
    }

    @Basic
    @Column(name = "DiscountFirst", nullable = true, precision = 0)
    public Double getDiscountFirst () {
        return discountFirst;
    }

    public void setDiscountFirst ( Double discountFirst ) {
        this.discountFirst = discountFirst;
    }

    @Basic
    @Column(name = "DiscountSecond", nullable = true, precision = 0)
    public Double getDiscountSecond () {
        return discountSecond;
    }

    public void setDiscountSecond ( Double discountSecond ) {
        this.discountSecond = discountSecond;
    }

    @Basic
    @Column(name = "DiscountThird", nullable = true, precision = 0)
    public Double getDiscountThird () {
        return discountThird;
    }

    public void setDiscountThird ( Double discountThird ) {
        this.discountThird = discountThird;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId () {
        return id;
    }

    public void setId ( int id ) {
        this.id = id;
    }

    @Override
    public boolean equals ( Object o ) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DiscountEntity that = (DiscountEntity) o;

        if (id != that.id) return false;
        if (totalFirst != null ? !totalFirst.equals(that.totalFirst) : that.totalFirst != null) return false;
        if (totalSecond != null ? !totalSecond.equals(that.totalSecond) : that.totalSecond != null) return false;
        if (totalThird != null ? !totalThird.equals(that.totalThird) : that.totalThird != null) return false;
        if (discountFirst != null ? !discountFirst.equals(that.discountFirst) : that.discountFirst != null)
            return false;
        if (discountSecond != null ? !discountSecond.equals(that.discountSecond) : that.discountSecond != null)
            return false;
        if (discountThird != null ? !discountThird.equals(that.discountThird) : that.discountThird != null)
            return false;

        return true;
    }

    @Override
    public int hashCode () {
        int result = totalFirst != null ? totalFirst.hashCode() : 0;
        result = 31 * result + (totalSecond != null ? totalSecond.hashCode() : 0);
        result = 31 * result + (totalThird != null ? totalThird.hashCode() : 0);
        result = 31 * result + (discountFirst != null ? discountFirst.hashCode() : 0);
        result = 31 * result + (discountSecond != null ? discountSecond.hashCode() : 0);
        result = 31 * result + (discountThird != null ? discountThird.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
