package top.flvio.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.flvio.entity.About;

import java.util.List;

/**
*@Author:flvio
*@Description:关于我 持久层接口
*@Params:
*/
@Mapper
@Repository
public interface AboutMapper {
    List<About> getList();
}
