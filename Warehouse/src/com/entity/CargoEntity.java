package com.entity;

import javax.persistence.*;

/**
 * Created by Pealing on 2017/9/2.
 */
@Entity
@Table(name = "cargo", schema = "warehouse", catalog = "")
public class CargoEntity {
    private int id;
    private String name;
    private int stock;
    private double price;
    private int minstock;

    @Id
    @Column(name = "id", nullable = false)
    public int getId () {
        return id;
    }

    public void setId ( int id ) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 127)
    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    @Basic
    @Column(name = "stock", nullable = false)
    public int getStock () {
        return stock;
    }

    public void setStock ( int stock ) {
        this.stock = stock;
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
    @Column(name = "minstock", nullable = false)
    public int getMinstock () {
        return minstock;
    }

    public void setMinstock ( int minstock ) {
        this.minstock = minstock;
    }

    @Override
    public boolean equals ( Object o ) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CargoEntity that = (CargoEntity) o;

        if (id != that.id) return false;
        if (stock != that.stock) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (minstock != that.minstock) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode () {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + stock;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + minstock;
        return result;
    }
}
