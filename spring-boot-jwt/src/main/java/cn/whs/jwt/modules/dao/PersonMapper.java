package cn.whs.jwt.modules.dao;

import cn.whs.jwt.modules.entity.Person;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-15 12:58
 */
public interface PersonMapper extends BaseMapper<Person> {

    /**
     * 获取同名列表
     */
    List<Person> selectByName(@Param("name") String name);
}
