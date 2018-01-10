package cn.whsxt.car.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.whsxt.car.service.CarService;
import cn.whsxt.car.vo.CarVo;
import cn.whsxt.car.vo.PageForList;

@Controller
public class CarController {

	@Autowired
	private CarService carService;

	/**
	 * 跳转汽车列表界面
	 */
	@RequestMapping("/toCarList")
	public String toCarList() {
		return "car/carList";
	}

	/**
	 * 查询所有汽车信息
	 */
	@RequestMapping("/queryCar")
	@ResponseBody
	public PageForList queryCar(CarVo carVo) {
		return carService.queryCar(carVo);
	}

	/**
	 * 上传汽车图片文件
	 */
	@RequestMapping("/saveCarImg")
	@ResponseBody
	public Map<String, Object> saveCarImg(CarVo carVo)
			throws IllegalStateException, IOException {
		// 获取文件名
		String filename = carVo.getFile().getOriginalFilename();
		Map<String, Object> map = new HashMap<String, Object>();
		if (filename != null && "".equals(filename)) {
			// 生成新的文件名
			String newName = UUID.randomUUID().toString().replace("-", "")
					.toUpperCase()
					+ filename.substring(filename.indexOf("."));
			String path = "D:\\Program Files\\MyEclipse\\Workspaces\\MyEclipse Professional 2014\\27_ssm_car\\pic\\";
			File file = new File(path, newName);
			carVo.getFile().transferTo(file);
			map.put("path", newName);
		}

		return map;
	}

	/**
	 * 添加汽车信息
	 */
	@RequestMapping("/saveCar")
	@ResponseBody
	public String saveCar(CarVo carVo) {
		carService.saveCar(carVo);
		return null;
	}

	/**
	 * 修改汽车信息
	 */
	@RequestMapping("/updateCar")
	@ResponseBody
	public String updateCar(CarVo carVo) {
		carService.updateCar(carVo);
		return null;
	}

	/**
	 * 删除汽车信息
	 */
	@RequestMapping("/deleteCar")
	@ResponseBody
	public Object deleteCar(CarVo carVo) {
		carService.deleteCar(carVo);
		return null;
	}

}
