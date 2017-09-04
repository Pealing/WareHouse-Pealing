package com.cargo.action;

import com.cargo.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.utils.action.ActionVariableSupport;

/**
 * Created by Pealing on 2017/8/31.
 */
@Controller
public class CargoDelete extends ActionVariableSupport{
    // 使用CargoService进行事务请求
    private final CargoService cargoService;

    @Autowired
    public CargoDelete(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    // 删除
    public String execute() throws Exception {
        System.out.println("action delete");
        String cargoname = httpServletRequest.getParameter("cargoname");
        cargoService.delete(cargoname);
        return SUCCESS;
    }

}
