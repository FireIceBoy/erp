package com.whsxt.service;

import java.util.List;

import com.whsxt.pojo.Outport;
import com.whsxt.utils.bean.PageBean;
import com.whsxt.vo.OutportVo;

public interface OutportService {

	void add(Outport outport, int outportId);

	void del(int id);

	List<Outport> query(PageBean pageBean, OutportVo outportVo);
	
	List<Outport> queryByGid(int gid);

}
