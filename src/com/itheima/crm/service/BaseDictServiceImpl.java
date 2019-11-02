package com.itheima.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.crm.mapper.BaseDictDao;
import com.itheima.crm.pojo.BaseDict;

@Service
//@Transactional
public class BaseDictServiceImpl implements BaseDictService {

	@Autowired
	private BaseDictDao bDao;
	@Override
	public List<BaseDict> selectBaseDictByCode(String code) {
		
		return bDao.selectBaseDictByCode(code);
	}

}
