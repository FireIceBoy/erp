package com.whsxt.service;

import java.util.List;

import com.whsxt.pojo.Inport;
import com.whsxt.utils.bean.PageBean;
import com.whsxt.vo.InportVo;

public interface InportService {
	void add(Inport inport);

	void del(int id);

	void update(Inport inport);

	List<Inport> query(PageBean pageBean, InportVo inportVo);
	
	List<Inport> queryByGid(int gid);

	InportVo queryById(int id);
}
