package com.whsxt.dao;

import java.util.List;

import com.whsxt.pojo.Outport;
import com.whsxt.utils.bean.PageBean;
import com.whsxt.vo.OutportVo;

public interface OutportDao {

	void add(Outport Outport);

	void del(int id);

	List<Outport> query(PageBean pageBean, OutportVo outportVo);

	List<Outport> queryByGid(int gid);
	
}
