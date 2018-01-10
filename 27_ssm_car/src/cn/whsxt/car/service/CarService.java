package cn.whsxt.car.service;

import cn.whsxt.car.vo.CarVo;
import cn.whsxt.car.vo.PageForList;

public interface CarService {
	
	PageForList queryCar(CarVo carVo);

	void saveCar(CarVo carVo);
	
	void updateCar(CarVo carVo);
	
	void deleteCar(CarVo carVo);
}
