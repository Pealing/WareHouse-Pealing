package com.discount.action;

import com.discount.service.DiscountService;
import com.utils.action.ActionVariableSupport;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Pealing on 2017/9/4.
 */
public class setSetting extends ActionVariableSupport{
    // 使用CargoService进行事务请求
    private final DiscountService discountService;


    @Autowired
    public setSetting ( DiscountService discountService ) {
        this.discountService = discountService;
    }

    public String execute() throws Exception {
        double TotalFirst = Double.valueOf(httpServletRequest.getParameter("TotalFirst"));
        double TotalSecond = Double.valueOf(httpServletRequest.getParameter("TotalSecond"));
        double TotalThird = Double.valueOf(httpServletRequest.getParameter("TotalThird"));
        double DiscountFirst = Double.valueOf(httpServletRequest.getParameter("DiscountFirst"));
        double DiscountSecond = Double.valueOf(httpServletRequest.getParameter("DiscountSecond"));
        double DiscountThird = Double.valueOf(httpServletRequest.getParameter("DiscountThird"));
        discountService.setSetting(3, TotalFirst, TotalSecond, TotalThird, DiscountFirst, DiscountSecond, DiscountThird);
        return SUCCESS;
    }
}
