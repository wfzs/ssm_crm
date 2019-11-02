package com.itheima.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.common.utils.Page;
import com.itheima.crm.pojo.BaseDict;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.service.BaseDictService;
import com.itheima.crm.service.CustomerService;

/**
 * 客户管理
 * @author win10
 *
 */
@Controller
public class CustomerController {
	
	@Autowired
	private BaseDictService bService;
	@Autowired
	private CustomerService cService;
	@Value("${fromType_code}")
	private String fromTypeCode;
	@Value("${industryType_code}")
	private String industryTypeCode;
	@Value("${levelType_code}")
	private String levelTypeCode;
	
	//入口
	@RequestMapping(value="/customer/list")
	public String list(QueryVo vo,Model model){
		List<BaseDict> fromType = bService.selectBaseDictByCode(fromTypeCode);
		List<BaseDict> industryType = bService.selectBaseDictByCode(industryTypeCode);
		List<BaseDict> levelType = bService.selectBaseDictByCode(levelTypeCode);
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		Page<Customer> page = cService.selectPageByQueryVo(vo);
		model.addAttribute("page", page);
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		
		return "customer";
	}
	@RequestMapping("customer/edit.action")
	public @ResponseBody 
	Customer edit(Integer id){
		return cService.selectById(id);
	}
	@RequestMapping("customer/update.action")
	public @ResponseBody 
	String update(Customer customer){
		cService.updateById(customer);
		return "OK";
	}
	@RequestMapping("customer/delete.action")
	public @ResponseBody 
	String  delete(Integer id){
		cService.deleteById(id);
		return "OK";
	}
}
