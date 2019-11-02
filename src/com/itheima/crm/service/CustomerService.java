package com.itheima.crm.service;

import java.util.List;

import com.itheima.common.utils.Page;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;

public interface CustomerService {

	public Page<Customer> selectPageByQueryVo(QueryVo vo);
	Customer selectById(Integer id);
	void updateById(Customer customer);
	void deleteById(Integer id);
}
