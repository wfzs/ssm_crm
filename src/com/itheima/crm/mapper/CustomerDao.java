package com.itheima.crm.mapper;

import java.util.List;

import com.itheima.crm.pojo.BaseDict;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;

public interface CustomerDao {

	public Integer CustomerCount(QueryVo vo);
	public List<Customer> selectCustomerByQueryVo(QueryVo vo);
	public Customer selectById(Integer id);
	public void updateById(Customer customer);
	public void  deleteById(Integer id);
}
