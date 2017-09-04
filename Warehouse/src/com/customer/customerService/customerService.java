package com.customer.customerService;

import com.entity.CustomerEntity;

import java.util.List;

/**
 * Created by Pealing on 2017/9/3.
 */
public interface customerService {
        /**
         * 创建新客户
         *
         * @param customer 客户实体
         */
        void create( CustomerEntity customer);

        /**
         * 删除客户
         *
         * @param customername 客户实体名称
         */
        void delete( String customername);

        /**
         * 设置客户等级
         *
         * @param custmoername 客户名称
         * @param level 客户等级
         */
        void setLevel(String custmoername, int level);

        /**
         * 商家设置客户等级
         *
         * @param custmoername 客户名称
         * @param level 客户等级
         */
        void setFirstLevel(String custmoername, int level);


        /**
         * @param custmoername 客户名称
         * @param phone 客户电话
         */
        void setnewPhone(String custmoername, String phone);

        /**
         * 获取所有客户实体
         *
         * @return 所有的客户实体
         */
        List<CustomerEntity> getAllCustomerEntities();

        /**
         * 根据用户名获取用户
         *
         * @param customername 客户名
         * @return 客户实体
         */
        CustomerEntity getByCustomername(String customername);

        /**
         * 检测客户是否存在
         *
         * @param customername 用户名
         * @return 是否存在
         */
        boolean chkCustomerrname(String customername);

        /**
         * 更新用户
         *
         * @param customerEntity 客户实体
         */
        void update(CustomerEntity customerEntity);

        /**
         * 根据ID获取用户
         *
         * @param id 客户ID
         * @return 客户实体
         */
        CustomerEntity getById(int id);
}
