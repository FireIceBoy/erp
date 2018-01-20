package com.whsxt.dao;

import java.util.List;

import com.whsxt.pojo.Inport;
import com.whsxt.utils.bean.PageBean;
import com.whsxt.vo.InportVo;

public interface InportDao {

	void add(Inport inport);

	void del(int id);

	void update(Inport inport);

	List<Inport> query(PageBean pageBean, InportVo inportVo);
	
	List<Inport> queryByGid(int gid);

	Inport queryById(int id);
}
