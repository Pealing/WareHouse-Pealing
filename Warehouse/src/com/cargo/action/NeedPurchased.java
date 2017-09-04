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
public class NeedPurchased extends ActionVariableSupport {

    // 使用CargoService进行事务请求
    private final CargoService cargoService;

    private int cargoid;

    @Autowired
    public NeedPurchased(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    // 删除
    public String execute() throws Exception {
        if(cargoService.needpurchased(cargoid))
        {
                return ERROR;
        }
        else
        {
            return SUCCESS;
        }
    }
}
