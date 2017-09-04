package com.sell.dao;

import com.entity.SellEntity;

import java.util.List;

/**
 * Created by Pealing on 2017/8/30.
 */
public interface sellDAO {
    /**
     * 创建新订单
     *
     * @param SellEntity 订单实体
     */
    void create( SellEntity sell);

    /**
     * 获取所有订单实体
     *
     * @return 所有的订单
     */
    List<SellEntity> getAllSellEntities();

    /**
     * 根据客户名字获取订货单实体
     *
     * @param customername 客户名字
     * @return 进货单实体
     */
    List<SellEntity> getSellByCustomername(int customerid);

    /**
     * 根据供货商获取进货单实体
     *
     * @param time 时间
     * @return 订货单实体
     */
    List<SellEntity> getSellByTime(String time);
    /**
     * 根据货物获取进货单实体
     *
     * @param cargoname 货物名称
     * @return 进货单实体
     */
    List<SellEntity> getSellByCargo(int cargoid);
}
