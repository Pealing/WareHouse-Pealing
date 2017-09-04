package com.cargo.action;

import com.cargo.service.CargoService;
import com.entity.CargoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.utils.action.ActionVariableSupport;

/**
 * Created by Pealing on 2017/9/1.
 */
@Controller
public class setMinstock extends ActionVariableSupport {

    // 使用CargoService进行事务请求
    private final CargoService cargoService;


    @Autowired
    public setMinstock(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    // 修改最小库存
    public String execute() throws Exception {
        String cargoname = httpServletRequest.getParameter("cargoname");
        int minstock = Integer.parseInt(httpServletRequest.getParameter("newminstock"));
        cargoService.setMinstock(cargoname, minstock);
        return SUCCESS;
    }
}
