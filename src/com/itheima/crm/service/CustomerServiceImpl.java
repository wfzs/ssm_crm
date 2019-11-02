package com.itheima.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.common.utils.Page;
import com.itheima.crm.mapper.CustomerDao;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;

import javafx.geometry.VPos;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao cDao;

	@Override
	public Page<Customer> selectPageByQueryVo(QueryVo vo) {
		Page<Customer> page =new Page<Customer>();
		page.setSize(5);
		vo.setSize(5);
		if(null != vo){			
			if(null != vo.getPage()){
				page.setPage(vo.getPage());
				vo.setStart((vo.getPage()-1)*vo.getSize());
			}			
			if(null != vo.getCustName()&&!"".equals(vo.getCustName())){
				vo.setCustName(vo.getCustName().trim());
			}
			if(null != vo.getCustSource()&&!"".equals(vo.getCustSource())){
				vo.setCustSource(vo.getCustSource().trim());
			}
			if(null != vo.getCustIndustry()&&!"".equals(vo.getCustIndustry())){
				vo.setCustIndustry(vo.getCustIndustry().trim());
			}
			if(null != vo.getCustLevel()&&!"".equals(vo.getCustLevel())){
				vo.setCustLevel(vo.getCustLevel().trim());
			}
			page.setTotal(cDao.CustomerCount(vo));
			page.setRows(cDao.selectCustomerByQueryVo(vo));
		}
		return page;
	}

	@Override
	public Customer selectById(Integer id) {		
		return cDao.selectById(id);
	}

	@Override
	public void updateById(Customer customer) {
		cDao.updateById(customer);
	}

	@Override
	public void deleteById(Integer id) {
		cDao.deleteById(id);
	}

}
