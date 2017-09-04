package com.cargo.service;

import com.entity.CargoEntity;

import java.util.List;

/**
 * Created by Pealing on 2017/8/31.
 */
public interface CargoService {
    /**
     * 创建新货物
     * @param cargoentity 货物实体
     */
    void create (CargoEntity cargoentity);

    /**
     * 根据名称删除货物
     * @param cargoname
     */
    void delete (String cargoname);
    /**
     * 设置货物最小库存
     * 库存小于该值则提醒补货
     * @param  cargoname 货物实体id
     * @param MinStock 最小库存值
     */
    void setMinstock( String cargoname, int MinStock);
    /**
     * 设置货物单价
     * @param  cargoname 货物实体id
     * @param price 新单价
     */
    void setPrice( String cargoname, int price);

    /**
     * 判断是否需要补货
     * 库存小于该值则题型补货
     * @param id 当前货物id
     */

    boolean needpurchased(int id);
    /**
     * 检测货物是否存在
     *
     * @param cargoname 货物名
     * @return 是否存在
     */
    boolean chkCargoname(String cargoname);

    /**
     * 根据ID获取货物
     *
     * @param id 货物ID
     * @return 货物实体
     */
    CargoEntity getById( int id);

    /**
     * 根据ID获取货物
     *
     * @param cargoname 货物名称
     * @return 货物实体
     */
    CargoEntity getByCargoname(String cargoname);
    /**
     * 获取所有货物实体
     *
     * @return 所有的货物实体
     */
    List<CargoEntity> getAllCargoEntity();
    /**
     * 更新货物
     *
     * @param cargoEntity 货物实体
     */
    void update(CargoEntity cargoEntity);
}
