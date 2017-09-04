package com.cargo.action;

import com.cargo.service.CargoService;
import com.entity.CargoEntity;
import com.utils.action.ActionVariableSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Pealing on 2017/9/2.
 */
@Controller
public class setPrice extends ActionVariableSupport {
    // 使用CargoService进行事务请求
    private final CargoService cargoService;


    @Autowired
    public setPrice(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    // 设置新单价
    public String execute() throws Exception {
        String cargoname = httpServletRequest.getParameter("cargoname");
        int price = Integer.parseInt(httpServletRequest.getParameter("newprice"));
        cargoService.setPrice(cargoname, price);
        return SUCCESS;
    }

}
