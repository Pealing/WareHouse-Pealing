package com.discount.dao;

import com.entity.DiscountEntity;

/**
 * Created by Pealing on 2017/9/4.
 */
public interface DiscountDAO {
    DiscountEntity getById( int id);

    /**
     * @param id
     * @param totalfirst 等级1 年消费
     * @param totalsecond 等级2 年消费
     * @param totalthird 等级3 年消费
     * @param discountfirst 等级1 折扣
     * @param discountsecond 等级2 折扣
     * @param discountthird 等级3 折扣
     */
    void  setSetting(int id, double totalfirst,double totalsecond, double totalthird, double discountfirst, double discountsecond, double discountthird);

    double getTotalFirst(int id);
    double getTotalSecond(int id);
    double getTotalThird(int id);
    double getDiscountFirst(int id);
    double getDiscountSecond(int id);
    double getDiscountThird(int id);

}
