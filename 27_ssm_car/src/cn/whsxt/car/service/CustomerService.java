package cn.whsxt.car.service;

import cn.whsxt.car.vo.CustomerVo;
import cn.whsxt.car.vo.PageForList;

public interface CustomerService {
	PageForList queryCustomer(CustomerVo customerVo);

	void saveCustomer(CustomerVo customerVo);

	void updateCustomer(CustomerVo customerVo);

	void deleteCustomer(String identity);
}
