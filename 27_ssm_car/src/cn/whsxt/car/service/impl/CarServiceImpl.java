package cn.whsxt.car.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.whsxt.car.mapper.CarMapper;
import cn.whsxt.car.pojo.Car;
import cn.whsxt.car.pojo.CarExample;
import cn.whsxt.car.service.CarService;
import cn.whsxt.car.vo.CarVo;
import cn.whsxt.car.vo.PageForList;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarMapper carMapper;

	/**
	 * 查询所有汽车信息
	 */
	@Override
	public PageForList queryCar(CarVo carVo) {
		PageHelper.startPage(carVo.getPage(), carVo.getRows());
		CarExample example = new CarExample();
		List<Car> list = carMapper.selectByExampleWithBLOBs(example);
		long total = new PageInfo<Car>(list).getTotal();
		PageForList pageForList = new PageForList();
		pageForList.setTotal(total);
		pageForList.setRows(list);
		return pageForList;
	}
	
	/**
	 * 添加
	 */
	@Override
	public void saveCar(CarVo carVo) {
		carMapper.insert(carVo);
	}

	/**
	 * 修改
	 */
	@Override
	public void updateCar(CarVo carVo) {
		carMapper.updateByPrimaryKeyWithBLOBs(carVo);
	}

	/**
	 * 删除
	 */
	@Override
	public void deleteCar(CarVo carVo) {
		carMapper.deleteByPrimaryKey(carVo.getCarnumber());
	}

}
