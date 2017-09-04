package com.discount.service.impl;

import com.discount.dao.DiscountDAO;
import com.discount.service.DiscountService;
import com.entity.DiscountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Pealing on 2017/9/4.
 */
@Service
public class DiscountServiceImpl implements DiscountService{
    private final DiscountDAO discountDAO;

    @Autowired
    public DiscountServiceImpl(DiscountDAO discountDAO) {
        System.out.println(discountDAO);
        this.discountDAO = discountDAO;
    }


    @Override
    public DiscountEntity getById ( int id ) {
        return discountDAO.getById(id);
    }

    @Override
    public void setSetting ( int id, double totalfirst, double totalsecond, double totalthird, double discountfirst, double discountsecond, double discountthird ) {
        discountDAO.setSetting(id, totalfirst,totalsecond,totalthird,discountfirst,discountsecond,discountthird);
    }

    @Override
    public double getTotalFirst ( int id ) {
        return discountDAO.getTotalFirst(id);
    }

    @Override
    public double getTotalSecond ( int id ) {
        return discountDAO.getTotalSecond(id);
    }

    @Override
    public double getTotalThird ( int id ) {
        return discountDAO.getTotalThird(id);
    }

    @Override
    public double getDiscountFirst ( int id ) {
        return discountDAO.getDiscountFirst(id);
    }

    @Override
    public double getDiscountSecond ( int id ) {
        return getDiscountSecond(id);
    }

    @Override
    public double getDiscountThird ( int id ) {
        return getDiscountThird(id);
    }
}
