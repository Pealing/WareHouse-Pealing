package com.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Pealing on 2017/9/2.
 */
@Entity
@Table(name = "sell", schema = "warehouse", catalog = "")
public class SellEntity {
    private int id;
    private int cargoId;
    private int customerId;
    private int num;
    private double price;
    private Timestamp data;

    @Id
    @Column(name = "id", nullable = false)
    public int getId () {
        return id;
    }

    public void setId ( int id ) {
        this.id = id;
    }

    @Basic
    @Column(name = "cargoId", nullable = false)
    public int getCargoId () {
        return cargoId;
    }

    public void setCargoId ( int cargoId ) {
        this.cargoId = cargoId;
    }

    @Basic
    @Column(name = "customerId", nullable = false)
    public int getCustomerId () {
        return customerId;
    }

    public void setCustomerId ( int customerId ) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "num", nullable = false)
    public int getNum () {
        return num;
    }

    public void setNum ( int num ) {
        this.num = num;
    }

    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    public double getPrice () {
        return price;
    }

    public void setPrice ( double price ) {
        this.price = price;
    }

    @Basic
    @Column(name = "data", nullable = true)
    public Timestamp getData () {
        return data;
    }

    public void setData ( Timestamp data ) {
        this.data = data;
    }

    @Override
    public boolean equals ( Object o ) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SellEntity that = (SellEntity) o;

        if (id != that.id) return false;
        if (cargoId != that.cargoId) return false;
        if (customerId != that.customerId) return false;
        if (num != that.num) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;

        return true;
    }

    @Override
    public int hashCode () {
        int result;
        long temp;
        result = id;
        result = 31 * result + cargoId;
        result = 31 * result + customerId;
        result = 31 * result + num;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }
}
