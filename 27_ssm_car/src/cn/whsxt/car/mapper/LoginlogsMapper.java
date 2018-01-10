package cn.whsxt.car.mapper;

import cn.whsxt.car.pojo.Loginlogs;
import cn.whsxt.car.pojo.LoginlogsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LoginlogsMapper {
    int countByExample(LoginlogsExample example);

    int deleteByExample(LoginlogsExample example);

    int deleteByPrimaryKey(Integer loginlogid);

    int insert(Loginlogs record);

    int insertSelective(Loginlogs record);

    List<Loginlogs> selectByExample(LoginlogsExample example);

    Loginlogs selectByPrimaryKey(Integer loginlogid);

    int updateByExampleSelective(@Param("record") Loginlogs record, @Param("example") LoginlogsExample example);

    int updateByExample(@Param("record") Loginlogs record, @Param("example") LoginlogsExample example);

    int updateByPrimaryKeySelective(Loginlogs record);

    int updateByPrimaryKey(Loginlogs record);
}