package com.entity;

import javax.persistence.*;

/**
 * Created by Pealing on 2017/9/4.
 */
@Entity
@Table(name = "customer", schema = "warehouse", catalog = "")
public class CustomerEntity {
    private int id;
    private String name;
    private Double yearTotal;
    private int level1;
    private String phone;
    private int firstlevel;

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
    @Column(name = "yearTotal", nullable = true, precision = 0)
    public Double getYearTotal () {
        return yearTotal;
    }

    public void setYearTotal ( Double yearTotal ) {
        this.yearTotal = yearTotal;
    }

    @Basic
    @Column(name = "level1", nullable = false)
    public int getLevel1 () {
        return level1;
    }

    public void setLevel1 ( int level1 ) {
        this.level1 = level1;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 127)
    public String getPhone () {
        return phone;
    }

    public void setPhone ( String phone ) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "Firstlevel", nullable = false)
    public int getFirstlevel () {
        return firstlevel;
    }

    public void setFirstlevel ( int firstlevel ) {
        this.firstlevel = firstlevel;
    }

    @Override
    public boolean equals ( Object o ) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerEntity that = (CustomerEntity) o;

        if (id != that.id) return false;
        if (level1 != that.level1) return false;
        if (firstlevel != that.firstlevel) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (yearTotal != null ? !yearTotal.equals(that.yearTotal) : that.yearTotal != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode () {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (yearTotal != null ? yearTotal.hashCode() : 0);
        result = 31 * result + level1;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + firstlevel;
        return result;
    }
}
