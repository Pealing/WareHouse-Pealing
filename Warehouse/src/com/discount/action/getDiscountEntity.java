package com.discount.action;

import com.discount.service.DiscountService;
import com.entity.DiscountEntity;
import com.utils.action.ActionVariableSupport;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Pealing on 2017/9/4.
 */
public class getDiscountEntity extends ActionVariableSupport {

    // 使用CargoService进行事务请求
    private final DiscountService discountService;


    @Autowired
    public getDiscountEntity ( DiscountService discountService ) {
        this.discountService = discountService;
    }

    public String execute() throws Exception {
        DiscountEntity discountEntity = discountService.getById(3);
        httpServletRequest.setAttribute("discountEntity", discountEntity);
        return SUCCESS;
    }
}
