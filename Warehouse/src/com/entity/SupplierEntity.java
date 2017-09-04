package com.entity;

import javax.persistence.*;

/**
 * Created by Pealing on 2017/9/3.
 */
@Entity
@Table(name = "supplier", schema = "warehouse", catalog = "")
public class SupplierEntity {
    private int id;
    private String name;
    private String phone;
    private String remarks;

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
    @Column(name = "phone", nullable = true, length = 127)
    public String getPhone () {
        return phone;
    }

    public void setPhone ( String phone ) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "remarks", nullable = true, length = 127)
    public String getRemarks () {
        return remarks;
    }

    public void setRemarks ( String remarks ) {
        this.remarks = remarks;
    }

    @Override
    public boolean equals ( Object o ) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SupplierEntity that = (SupplierEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (remarks != null ? !remarks.equals(that.remarks) : that.remarks != null) return false;

        return true;
    }

    @Override
    public int hashCode () {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (remarks != null ? remarks.hashCode() : 0);
        return result;
    }
}
