package cn.whsxt.car.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.whsxt.car.mapper.CustomersMapper;
import cn.whsxt.car.pojo.Customers;
import cn.whsxt.car.pojo.CustomersExample;
import cn.whsxt.car.pojo.CustomersExample.Criteria;
import cn.whsxt.car.service.CustomerService;
import cn.whsxt.car.vo.CustomerVo;
import cn.whsxt.car.vo.PageForList;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Controller
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomersMapper customersMapper;
	/**
	 * 
	 * 模糊分页查询
	 */
	@Override
	public PageForList queryCustomer(CustomerVo customerVo) {
		//分页
		PageHelper.startPage(customerVo.getPage(), customerVo.getRows());
		//模糊查询
		CustomersExample example = new CustomersExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdentityLike("%"+customerVo.getIdentity()+"%");
		criteria.andCustnameLike("%"+customerVo.getCustname()+"%");
		if(customerVo.getSex() != null) {
			criteria.andSexEqualTo(customerVo.getSex()+"%");
		}
		criteria.andAddressLike("%"+customerVo.getAddress()+"%");
		criteria.andPhoneLike("%"+customerVo.getPhone()+"%");
		criteria.andCareerLike("%"+customerVo.getCareer()+"%");
		List<Customers> list = customersMapper.selectByExample(example);
		long total = new PageInfo<Customers>(list).getTotal();
		PageForList pageForList = new PageForList();
		pageForList.setTotal(total);
		pageForList.setRows(list);
		return pageForList;
	}

	/**
	 * 添加
	 */
	@Override
	public void saveCustomer(CustomerVo customerVo) {
		customersMapper.insert(customerVo);
	}

	/**
	 * 修改
	 */
	@Override
	public void updateCustomer(CustomerVo customerVo) {
		customersMapper.updateByPrimaryKey(customerVo);
	}
	
	/**
	 * 删除
	 */
	@Override
	public void deleteCustomer(String identity) {
		customersMapper.deleteByPrimaryKey(identity);
	}

}
