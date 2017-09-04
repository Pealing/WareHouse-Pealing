package com.customer.action;

import com.customer.customerService.customerService;
import com.entity.CustomerEntity;
import com.opensymphony.xwork2.ModelDriven;
import com.utils.action.ActionVariableSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Pealing on 2017/9/3.
 */
@Controller
public class CustomerCreate extends ActionVariableSupport implements ModelDriven<CustomerEntity> {
    // 使用CargoService进行事务请求
    private final customerService customerservice;

    // Action所涉及的用户实体
    private CustomerEntity customerEntity;

    @Autowired
    public CustomerCreate(customerService customerservice) {
        this.customerservice = customerservice;
        customerEntity = new CustomerEntity();
    }

    public String execute()
    {
        if(customerservice.chkCustomerrname(customerEntity.getName()))
        {
            return ERROR;
        }
        try {
            customerservice.create(customerEntity);
        }catch (Exception e)
        {
            e.printStackTrace();
            return ERROR;
        }
        return SUCCESS;
    }

    @Override
    public CustomerEntity getModel () {
        return customerEntity;
    }
}
