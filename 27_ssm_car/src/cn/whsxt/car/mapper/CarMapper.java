package cn.whsxt.car.mapper;

import cn.whsxt.car.pojo.Car;
import cn.whsxt.car.pojo.CarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarMapper {
    int countByExample(CarExample example);

    int deleteByExample(CarExample example);

    int deleteByPrimaryKey(String carnumber);

    int insert(Car record);

    int insertSelective(Car record);

    List<Car> selectByExampleWithBLOBs(CarExample example);

    List<Car> selectByExample(CarExample example);

    Car selectByPrimaryKey(String carnumber);

    int updateByExampleSelective(@Param("record") Car record, @Param("example") CarExample example);

    int updateByExampleWithBLOBs(@Param("record") Car record, @Param("example") CarExample example);

    int updateByExample(@Param("record") Car record, @Param("example") CarExample example);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKeyWithBLOBs(Car record);

    int updateByPrimaryKey(Car record);
}