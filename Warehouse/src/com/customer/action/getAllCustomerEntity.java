package com.customer.action;

import com.customer.customerService.customerService;
import com.entity.CustomerEntity;
import com.utils.action.ActionVariableSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

import static com.opensymphony.xwork2.Action.SUCCESS;

/**
 * Created by Pealing on 2017/9/3.
 */
@Controller
public class getAllCustomerEntity extends ActionVariableSupport{
    // 使用CargoService进行事务请求
    private final customerService customerservice;


    @Autowired
    public getAllCustomerEntity(customerService customerservice) {
        this.customerservice = customerservice;
    }

    // 获取所有货物实体
    public String execute() throws Exception {
        List<CustomerEntity> customerEntitylist =  customerservice.getAllCustomerEntities();
        httpServletRequest.setAttribute("customerList", customerEntitylist);
        return SUCCESS;
    }
}
