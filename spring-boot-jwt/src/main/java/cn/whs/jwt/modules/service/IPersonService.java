package cn.whs.jwt.modules.service;

import cn.whs.jwt.modules.entity.Person;
import com.baomidou.mybatisplus.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-15 13:04
 */
public interface IPersonService extends IService<Person> {

    /**
     * 添加用户
     */
    void addPerson(String name);

    /**
     * 编辑用户
     */
    void editPerson(Integer personId, String personName);

    /**
     * 删除用户
     */
    void deletePerson(Integer personId);

    /**
     * 获取同名列表
     */
    List<Person> selectByName(@Param("name") String name);

}
